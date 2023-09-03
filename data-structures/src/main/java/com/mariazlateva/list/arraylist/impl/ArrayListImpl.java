package com.mariazlateva.list.arraylist.impl;

import com.mariazlateva.iterator.Iterator;
import com.mariazlateva.iterator.impl.ArrayIterator;
import com.mariazlateva.list.arraylist.ArrayList;

public class ArrayListImpl<T> implements ArrayList<T> {
    public static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] arrayList;


    //== constructors ==
    public ArrayListImpl() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayListImpl(int initialCapacity) {
        this.size = 0;
        if (initialCapacity < 0) {
            initialCapacity = DEFAULT_CAPACITY;
        }
        this.arrayList = new Object[initialCapacity];
    }


    //== public methods ==
    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void add(int position, T item) {
        if (isIndexOutOfRange(position)) {
            throw new IndexOutOfBoundsException(indexOutOfRangeMsg(position));
        }
        if (isFull()) {
            int newCapacity = determineNewCapacity();
            arrayList = growArrayList(newCapacity);
        }

        System.arraycopy(arrayList, position, arrayList, position + 1, size - position);
        arrayList[position] = (T) item;
        size++;
    }

    @Override
    public T get(int position) {
        if (isIndexOutOfRange(position)) {
            throw new IndexOutOfBoundsException(indexOutOfRangeMsg(position));
        }
        return (T) arrayList[position];
    }

    @Override
    public T remove(int position) {
        if (isIndexOutOfRange(position)) {
            throw new IndexOutOfBoundsException(indexOutOfRangeMsg(position));
        }
        T itemToRemove = (T) arrayList[position];
        System.arraycopy(arrayList, position + 1, arrayList, position, size - position - 1);
        arrayList[size - 1] = null;
        size--;
        return itemToRemove;
    }

    @Override
    public T remove(T item) {
        int itemPosition = indexOf(item);
        //if (itemPosition < 0)
        //{
        //    return default(T);
        //}
        return remove(itemPosition);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T item) {
        return indexOf(item) >= 0;
    }

    @Override
    public Iterator<T> iterator() {
        Object[] arrayListCopy = growArrayList(arrayList.length);
        return new ArrayIterator<T>(arrayListCopy);
    }


    //== private methods ==
    private void addLast(T item) {
        if (isFull()) {
            int newCapacity = determineNewCapacity();
            arrayList = growArrayList(newCapacity);
        }
        arrayList[size++] = (T) item;
    }

    private boolean isFull() {
        return size == arrayList.length;
    }

    private boolean isIndexInRange(int index) {
        return index >= 0 && index < arrayList.length;
    }

    private boolean isIndexOutOfRange(int index) {
        if (size == 0) {
            return index < 0 || index > size;
        }

        return index < 0 || index >= size;
    }

    private String indexOutOfRangeMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private int indexOf(T item) {
        if (item == null) {
            for (int i = 0; i < size; i++) {
                if (arrayList[i] == null) {
                    return i;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            T current = (T) arrayList[i];
            if (current.equals(item)) {
                return i;
            }
        }
        return -1;
    }

    private int determineNewCapacity() {
        int arrayListCapacity = arrayList.length;
        if (arrayListCapacity == 0) {
            return DEFAULT_CAPACITY;// to default capacity
        } else if (arrayListCapacity < DEFAULT_CAPACITY * 2) {
            return arrayListCapacity * 2; // doubled capacity
        } else {
            return arrayListCapacity + (arrayListCapacity / 2);// with 50 % increase of the capacity
        }
    }

    private Object[] growArrayList(int grownListCapacity) {
        Object[] grownArrayList = new Object[grownListCapacity];
        System.arraycopy(arrayList, 0, grownArrayList, 0, size);
        return grownArrayList;
    }

}
