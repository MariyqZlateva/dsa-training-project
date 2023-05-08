package com.mariazlateva.sort.simple;

import com.mariazlateva.util.ThreadColor;
import com.mariazlateva.util.ThreadColorUtil;

import java.util.Arrays;
import java.util.Random;

public class SimpleSortTrainingTemplate {


    private static final SimpleSort bubbleSort = array -> {

    };

    private static final SimpleSort selectionSort = array -> {

    };

    private static final SimpleSort insertionSort = array -> {

    };

    private static final SimpleSort shellSort = array -> {

    };

    private static final SimpleSort mergeSort = new SimpleSort() {
        @Override
        public void sort(int[] array) {

        }
        // == private methods ==
    };

    private static final SimpleSort quickSort = new SimpleSort() {
        @Override
        public void sort(int[] array) {

        }
        //== private methods ==
    };


    public static void main(String[] args) {
        String title = "\t\t\t<<< Executing " + SimpleSortTrainingTemplate.class.getSimpleName() + " >>>";
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

        title = "\t\t\t<<< Execution of " + SimpleSortTrainingTemplate.class.getSimpleName() + " completed >>>";
        ThreadColorUtil.printInColor(title, ThreadColor.ANSI_GREEN);
    }

    private static void sortExecution(SimpleSort simpleSort, String msg) {
        int[] array = arrayGenerator(10, 10, 100);
        ThreadColorUtil.printInColor("Unsorted", ThreadColor.ANSI_RED);
        printArray(array, ThreadColor.ANSI_RED);
        simpleSort.sort(array);
        ThreadColorUtil.printInColor(msg, ThreadColor.ANSI_BLUE);
        printArray(array, ThreadColor.ANSI_BLUE);
    }

    private static void printArray(int[] array, ThreadColor printColor) {
        String arrayString = Arrays.toString(array);
        ThreadColorUtil.printInColor(arrayString, printColor);
    }

    private static int[] arrayGenerator(int arrayCapacity, int lowBound, int upBound) {
        Random random = new Random();
        int[] array = new int[arrayCapacity];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(lowBound, upBound);
        }
        return array;
    }

}
