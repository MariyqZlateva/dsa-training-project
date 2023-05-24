package com.mariazlateva.sort.simple.impl;

import com.mariazlateva.sort.simple.SimpleSort;

public class BubbleSort implements SimpleSort {

    /**
     * @param array Integer array to be sorted by the bubble sort algorithm
     *              Uses flag for optimization to signal if at any iteration the array is sorted
     *              The time complexity of bubble sort is O(n²)
     * @throws IndexOutOfBoundsException If {@code array} is null
     */
    @Override
    public void sort(int[] array) {
        SimpleSort.validateArray(array);
        for (int last = array.length - 1; last > 0; last--) {
            boolean isSorted = true;
            for (int current = 0; current < last; current++) {
                int next = current + 1;
                if (array[current] > array[next]) {
                    isSorted = false;
                    SimpleSort.swap(array, current, next);
                }
            }
            if (isSorted) {
                break;
            }
        }
    }


}
