package com.mariazlateva.queue.impl;

import com.mariazlateva.iterator.Iterator;
import com.mariazlateva.queue.Queue;
import com.mariazlateva.util.ThreadColor;
import com.mariazlateva.util.ThreadColorUtil;

public class QueueMain {

    public static void main(String[] args) {
        int queueCapacity = 1;
        Queue<Integer> queue = new QueueImpl<>(queueCapacity);
        queueSim(queue);
        ThreadColorUtil.printInColor("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++", ThreadColor.ANSI_PURPLE);
        Queue<Integer> trainingQueue = new QueueTrainingClass<>();
        queueSim(trainingQueue);
    }

    private static void queueSim(Queue<Integer> queue) {
        String title = "\t\t\t<<< Executing '" + queue.getClass().getSimpleName() + "' simulation >>>";
        ThreadColorUtil.printInColor(title, ThreadColor.ANSI_GREEN);

        try {
            System.out.println();
            ThreadColorUtil.printInColor("EmptyQueueException sim with queue.peek() with empty queue", ThreadColor.ANSI_RED);
            queue.peek();
        } catch (EmptyQueueException e) {
            ThreadColorUtil.printInColor("EmptyQueueException message: " + e.getMessage(), ThreadColor.ANSI_RED);
            System.out.println();
        }

        System.out.println("Queue.add(1)");
        queue.add(1);
        System.out.println("Queue.add(2)");
        queue.add(2);
        System.out.println("Queue.add(3)");
        queue.add(3);
        System.out.println("Queue.size() = " + queue.size());
        System.out.println("Queue.peek() = " + queue.peek());
        printQueue(queue);
        System.out.println();

        System.out.println("Queue.remove() = " + queue.remove());
        System.out.println("Queue.add(4)");
        queue.add(4);
        System.out.println("Queue.remove() = " + queue.remove());
        System.out.println("Queue.size() = " + queue.size());
        System.out.println("Queue.peek() = " + queue.peek());
        printQueue(queue);
        System.out.println();


        ThreadColorUtil.printInColor("Queue.add(5)... queue wrap", ThreadColor.ANSI_BLUE);
        queue.add(5);
        System.out.println("Queue.size() = " + queue.size());
        System.out.println("Queue.peek() = " + queue.peek());
        printQueue(queue);
        System.out.println();

        System.out.println("Queue.add(6)");
        queue.add(6);
        System.out.println("Queue.size() = " + queue.size());
        System.out.println("Queue.peek() = " + queue.peek());
        printQueue(queue);

        title = "\t\t\t<<< Execution of '" + queue.getClass().getSimpleName() + "' simulation completed >>>";
        ThreadColorUtil.printInColor(title, ThreadColor.ANSI_GREEN);
    }

    private static <T> void printQueue(Queue<T> queue) {
        String msg = "Queue: ";
        Iterator<T> queueIterator = queue.iterator();
        while (queueIterator.hasNext()) {
            msg += queueIterator.next() + " ";
        }
        System.out.println(msg);
    }

}
