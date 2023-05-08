package com.mariazlateva.queue;

import com.mariazlateva.iterator.Iterator;

public interface Queue<T> {

    void add(T item);

    T remove();

    T peek();

    int size();

    boolean isEmpty();

    Iterator<T> iterator();

}
