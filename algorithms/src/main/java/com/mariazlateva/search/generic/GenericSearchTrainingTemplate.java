package com.mariazlateva.search.generic;

import com.mariazlateva.util.ThreadColor;
import com.mariazlateva.util.ThreadColorUtil;

import java.util.Arrays;

public class GenericSearchTrainingTemplate {

    private static final int LINEAR_SEARCH_NUMBER = 21; // 2, 5, 1, 14, 31, 76, 13
    private static final int BINARY_SEARCH_NUMBER = 8; // 1, 2, 7, 12, 56, 74, 87

    private static GenericSearch<Integer> linearSearch = (array, itemToSearchFor) -> {


        return -1;
    };

    private static GenericSearch<Integer> binarySearch = (array, itemToSearchFor) -> {


        return -1;
    };

    public static void main(String[] args) {
        String title = "\t\t\t<<< Executing " + GenericSearchTrainingTemplate.class.getSimpleName() + " >>>";
        ThreadColorUtil.printInColor(title, ThreadColor.ANSI_CYAN);

        Integer[] unsortedArray = new Integer[]{2, 5, 1, 14, 31, 76, 13};
        String msg = "Linear search for number '" + LINEAR_SEARCH_NUMBER + "' in " + Arrays.toString(unsortedArray);
        ThreadColorUtil.printInColor(msg, ThreadColor.ANSI_GREEN);
        int result = linearSearch.search(unsortedArray, LINEAR_SEARCH_NUMBER);
        String resultMsg = result != -1 ? "Number '" + LINEAR_SEARCH_NUMBER + "' found at position " + result + "." : "Number '" + LINEAR_SEARCH_NUMBER + "' not found in the given array. ";
        ThreadColor color = result != -1 ? ThreadColor.ANSI_BLUE : ThreadColor.ANSI_RED;
        ThreadColorUtil.printInColor(resultMsg, color);

        System.out.println();

        Integer[] sortedArray = new Integer[]{1, 2, 7, 12, 56, 74, 87};
        msg = "Binary search for number '" + BINARY_SEARCH_NUMBER + "' in " + Arrays.toString(sortedArray);
        ThreadColorUtil.printInColor(msg, ThreadColor.ANSI_GREEN);
        result = binarySearch.search(sortedArray, BINARY_SEARCH_NUMBER);
        resultMsg = result != -1 ? "Number '" + BINARY_SEARCH_NUMBER + "' found at position " + result + "." : "Number '" + BINARY_SEARCH_NUMBER + "' not found in the given array. ";
        color = result != -1 ? ThreadColor.ANSI_BLUE : ThreadColor.ANSI_RED;
        ThreadColorUtil.printInColor(resultMsg, color);

        title = "\t\t\t<<< Execution of " + GenericSearchTrainingTemplate.class.getSimpleName() + " completed >>>";
        ThreadColorUtil.printInColor(title, ThreadColor.ANSI_CYAN);
    }

}
