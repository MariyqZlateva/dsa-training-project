package com.mariazlateva.sort.simple.impl;

import com.mariazlateva.sort.simple.SimpleSort;

import java.util.Arrays;

public class InsertionSort implements SimpleSort {

    /**
     * @param array Integer array to be sorted by the insertion sort algorithm
     *              The time complexity of insertion sort is O(n²)
     * @throws IndexOutOfBoundsException If {@code array} is null
     */
    @Override
    public void sort(int[] array) {
        SimpleSort.validateArray(array);
        for (int first = 0; first < array.length; first++) {
            int candidate = array[first];
            int left;
            for (left = first; left > 0 && array[left - 1] > candidate; left--) {
                array[left] = array[left - 1];
            }
            array[left] = candidate;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 0, 1, -4, 19, 0, 1};
        System.out.println(Arrays.toString(arr));
        SimpleSort insertionSortsort = new InsertionSort();
        insertionSortsort.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
