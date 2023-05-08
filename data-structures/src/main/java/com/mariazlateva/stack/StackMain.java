package com.mariazlateva.stack;

import com.mariazlateva.iterator.Iterator;
import com.mariazlateva.stack.impl.StackImpl;
import com.mariazlateva.stack.impl.StackTrainingClass;
import com.mariazlateva.util.ThreadColor;
import com.mariazlateva.util.ThreadColorUtil;

import java.util.EmptyStackException;

public class StackMain {


    public static void main(String[] args) {
        Stack<Integer> stack = new StackImpl<>(1);
        stackSimulation(stack);

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        Stack<Integer> trainingStack = new StackTrainingClass<>();
        stackSimulation(trainingStack);

    }


    private static void stackSimulation(Stack<Integer> stack) {
        String title = "\t\t\t<<< Executing '" + stack.getClass().getSimpleName() + "' simulation >>>";
        ThreadColorUtil.printInColor(title, ThreadColor.ANSI_GREEN);

        for (int i = 1; i <= 5; i++) {
            System.out.println(stack.getClass().getSimpleName() + ":: push " + i);
            stack.push(i);
        }

        Iterator<Integer> iterator = stack.iterator();
        System.out.println("Stack:");
        iteratorPrinter(iterator);

        System.out.println("Peek = " + stack.peek());
        System.out.println("Pop = " + stack.pop());

        iterator = stack.iterator();
        System.out.println("Stack:");
        iteratorPrinter(iterator);

        while (!stack.isEmpty()) {
            System.out.println("Pop = " + stack.pop());
        }

        iterator = stack.iterator();
        iteratorPrinter(iterator);

        try {
            Integer v = stack.peek();
        } catch (EmptyStackException e) {
            e.printStackTrace();
        }
        System.out.println();

        try {
            Integer v = stack.pop();
        } catch (EmptyStackException e) {
            e.printStackTrace();
        }
        System.out.println();

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
        System.out.println();

        title = "\t\t\t<<< Execution of '" + stack.getClass().getSimpleName() + "' simulation completed >>>";
        ThreadColorUtil.printInColor(title, ThreadColor.ANSI_GREEN);
    }

    private static <T> void iteratorPrinter(Iterator<T> iterator) {
        while (iterator.hasNext()) {
            System.out.println("\t[" + iterator.next() + "]");
        }
    }

}
