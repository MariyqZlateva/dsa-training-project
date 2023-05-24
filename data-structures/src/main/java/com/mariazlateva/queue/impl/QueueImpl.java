package com.mariazlateva.queue.impl;

import com.mariazlateva.iterator.Iterator;
import com.mariazlateva.iterator.impl.ArrayIterator;
import com.mariazlateva.queue.Queue;

public class QueueImpl<T> implements Queue<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] queue;
    private int front;
    private int back;

    public QueueImpl() {
        this(DEFAULT_CAPACITY);
    }

    public QueueImpl(int capacity) {
        if (capacity < 1) {
           increaseCapacity();
        }
        this.front = 0;
        this.back = 0;
        this.queue = new Object[capacity];
    }

    @Override
    public void add(T item) {
        if (size() == queue.length - 1) {
            increaseCapacity();
        }
        queue[back] = item;
        if (back == queue.length - 1) {
            back = 0;
        } else {
            back++;
        }
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty.");
        }
        T value = (T) queue[front];
        queue[front] = null;
        front++;
        if (isEmpty()) {
            front = 0;
            back = 0;
        }
        if (front == queue.length) {
            front = 0;
        }
        return value;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty.");
        }
        return (T) this.queue[front];
    }

    @Override
    public int size() {
        if (front <= back) {
            return back - front;
        } else {
            return back - front + queue.length;
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(copyQ(size()));
    }

    //== private methods ==
    private void increaseCapacity() {
        int numberOfItems = size();
        int newCapacity = determineNewCapacity();
        queue = copyQ(newCapacity);
        front = 0;
        back = numberOfItems; // after 'front = 0;' size() method will work differently if the Queue was previously wrapped
    }

    private int determineNewCapacity() {
        int queueCapacity = queue.length;
        if (queueCapacity == 0) {
            return DEFAULT_CAPACITY;// to default capacity
        } else if (queueCapacity < DEFAULT_CAPACITY * 2) {
            return queueCapacity * 2; // doubled capacity
        } else {
            return queueCapacity + (queueCapacity / 2);// with 50 % increase of the capacity
        }
    }

    private Object[] copyQ(int capacity) {
        Object[] copy = new Object[capacity];
        int tmp = size();
        if (front <= back) {
            System.arraycopy(queue, front, copy, 0, tmp);
        } else {
            System.arraycopy(queue, front, copy, 0, queue.length - front);
            System.arraycopy(queue, 0, copy, queue.length - front, back);
        }
        return copy;
    }

}
