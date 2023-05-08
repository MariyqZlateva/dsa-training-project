package com.mariazlateva.search.generic;

public interface GenericSearch<T extends Comparable<T>> {

    int search(T[] array, T itemToSearchFor);

}
