package com.mariazlateva.sort.generic;

@FunctionalInterface
public interface GenericSort<T extends Comparable<T>> {

    void sort(T[] array);

}
