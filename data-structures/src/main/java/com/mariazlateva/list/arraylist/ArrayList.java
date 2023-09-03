package com.mariazlateva.list.arraylist;

import com.mariazlateva.iterator.Iterator;

public interface ArrayList<T> {

    void add(T item);

    void add(int position, T item);

    T get(int position);

    T remove(int position);

    T remove(T item);

    boolean isEmpty();

    int size();

    boolean contains(T item);

    Iterator<T> iterator();

}
