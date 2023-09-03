package com.mariazlateva.list.linkedlist;

import com.mariazlateva.iterator.Iterator;

public interface LinkedList<T> {

    void addFirst(T item);

    void addLast(T item);

    T removeFirst();

    T removeLast();

    T peekFirst();

    T peekLast();

    int size();

    boolean isEmpty();

    Iterator<T> iterator();

}
