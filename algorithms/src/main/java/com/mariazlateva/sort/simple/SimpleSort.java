package com.mariazlateva.sort.simple;

@FunctionalInterface
public interface SimpleSort {

    void sort(int[] array);

    static void swap(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            return;
        }
        if (array[leftIndex] == array[rightIndex]) {
            return;
        }
        int temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }

    static void validateArray(int[] array) {
        if (array == null) {
            throw new IndexOutOfBoundsException("Array is null");
        }
    }

}