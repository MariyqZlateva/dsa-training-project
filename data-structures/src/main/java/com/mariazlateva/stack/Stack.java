package com.mariazlateva.stack;

import com.mariazlateva.iterator.Iterator;

public interface Stack<T> {

    void push(T item);

    T pop();

    T peek();

    int size();

    boolean isEmpty();

    Iterator<T> iterator();

}
