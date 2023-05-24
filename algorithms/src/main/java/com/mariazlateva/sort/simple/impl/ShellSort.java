package com.mariazlateva.sort.simple.impl;

import com.mariazlateva.sort.simple.SimpleSort;

import java.util.Arrays;

public class ShellSort implements SimpleSort {

    /**
     * @param array Integer array to be sorted by the shell sort algorithm
     *              The time complexity of shell sort is O(n²)
     * @throws IndexOutOfBoundsException If {@code array} is null
     */
    @Override
    public void sort(int[] array) {
        for (int step = array.length / 2; step > 0; step /= 2) {
            for (int right = 0; right < array.length; right++) {
                int candidate = array[right];
                int left;
                for (left = right; left >= step && array[left - step] > candidate; left -= step) {
                    array[left] = array[left - step];
                }
                array[left] = candidate;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 0, 1, -4, 19, 0, 1};
        System.out.println(Arrays.toString(arr));
        SimpleSort shellSort = new ShellSort();
        shellSort.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
