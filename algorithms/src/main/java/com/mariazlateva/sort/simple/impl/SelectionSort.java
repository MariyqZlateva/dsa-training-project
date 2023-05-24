package com.mariazlateva.sort.simple.impl;

import com.mariazlateva.sort.simple.SimpleSort;

import java.util.Arrays;

public class SelectionSort implements SimpleSort {

    /**
     * @param array Integer array to be sorted by the selection sort algorithm
     *               The time complexity of selection sort is O(n²)
     * @throws IndexOutOfBoundsException If {@code array} is null
     */
    @Override
    public void sort(int[] array) {
        for (int last = array.length-1; last > 0; last--) {
            int max  = last;
            for (int current = 0; current < last; current++) {
                if (array[current]>array[max]){
                    max = current;
                }
            }
            SimpleSort.swap(array, max, last);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 0, 1, -4, 19, 0, 1};
        System.out.println(Arrays.toString(arr));
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));

    }

}
