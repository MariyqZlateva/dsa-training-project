package com.mariazlateva.sort.generic;

import com.mariazlateva.util.ThreadColor;
import com.mariazlateva.util.ThreadColorUtil;

import java.util.Arrays;
import java.util.Random;

public class GenericSortTrainingTemplate {


    private static final GenericSort<Integer> bubbleSort = array -> {

    };

    private static final GenericSort<Integer> selectionSort = array -> {

    };

    private static final GenericSort<Integer> insertionSort = array -> {

    };

    private static final GenericSort<Integer> shellSort = array -> {

    };

    private static final GenericSort<Integer> mergeSort = new GenericSort<Integer>() {
        @Override
        public void sort(Integer[] array) {

        }
        // == private methods ==
    };

    private static final GenericSort<Integer> quickSort = new GenericSort<Integer>() {
        @Override
        public void sort(Integer[] array) {

        }
        //== private methods ==
    };


    public static void main(String[] args) {
        String title = "\t\t\t<<< Executing " + GenericSortTrainingTemplate.class.getSimpleName() + " >>>";
        ThreadColorUtil.printInColor(title, ThreadColor.ANSI_GREEN);

        sortExecution(bubbleSort, "Bubble sort applied");
        System.out.println();
        sortExecution(selectionSort, "Selection sort applied");
        System.out.println();
        sortExecution(insertionSort, "Insertion sort applied");
        System.out.println();
        sortExecution(shellSort, "Shell sort applied");
        System.out.println();
        sortExecution(mergeSort, "Merge sort applied");
        System.out.println();
        sortExecution(quickSort, "Quick sort applied");

        title = "\t\t\t<<< Execution of " + GenericSortTrainingTemplate.class.getSimpleName() + " completed >>>";
        ThreadColorUtil.printInColor(title, ThreadColor.ANSI_GREEN);
    }

    private static void sortExecution(GenericSort<Integer> genericSort, String msg) {
        Integer[] array = arrayGenerator(10, 10, 100);
        ThreadColorUtil.printInColor("Unsorted", ThreadColor.ANSI_RED);
        printArray(array, ThreadColor.ANSI_RED);
        genericSort.sort(array);
        ThreadColorUtil.printInColor(msg, ThreadColor.ANSI_BLUE);
        printArray(array, ThreadColor.ANSI_BLUE);
    }

    private static void printArray(Integer[] array, ThreadColor printColor) {
        String arrayString = Arrays.toString(array);
        ThreadColorUtil.printInColor(arrayString, printColor);
    }

    private static Integer[] arrayGenerator(int arrayCapacity, int lowBound, int upBound) {
        Random random = new Random();
        Integer[] array = new Integer[arrayCapacity];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(lowBound, upBound);
        }
        return array;
    }

}
