package com.mariazlateva.iterator.impl;

import com.mariazlateva.iterator.Iterator;

public class ArrayIterator<T> implements Iterator<T> {

    private final Object[] array;
    private int position;

    public ArrayIterator(Object[] array) {
        this.array = array;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < array.length && array[position] != null;
    }

    @Override
    public T next() {
        return (T) array[position++];
    }
}
