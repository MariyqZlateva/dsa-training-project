package com.mariazlateva.list.linkedlist;


import com.mariazlateva.iterator.Iterator;
import com.mariazlateva.list.linkedlist.impl.LinkedListImpl;
import com.mariazlateva.list.linkedlist.impl.LinkedListTrainingClass;

import java.util.Random;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedListImpl<Integer> doubleListInteger = new LinkedListImpl<>();
        LinkedListTrainingClass<Integer> linkedListTrainingClass = new LinkedListTrainingClass<>();

        initList(doubleListInteger);
        initList(linkedListTrainingClass);
        System.out.print("Linked list impl: ");
        printList(doubleListInteger);
        System.out.print("Linked list Training class: ");
        printList(linkedListTrainingClass);

        System.out.println("Linked List size() = " + doubleListInteger.size());
        System.out.println("Linked List Training class size() = " + linkedListTrainingClass.size());

        System.out.println("Linked List peekedFirst() = " + doubleListInteger.peekFirst());
        System.out.println("Linked List Training class peekedFirst() = " + linkedListTrainingClass.peekFirst());

        System.out.println("Linked List peekedLast() = " + doubleListInteger.peekLast());
        System.out.println("Linked List Training class peekedLast() = " + linkedListTrainingClass.peekLast());

        System.out.println("Linked List addFirst(0)");
        doubleListInteger.addFirst(0);

        System.out.println("Linked List Training class addFirst(0)");
        linkedListTrainingClass.addFirst(0);
        printList(doubleListInteger);
        printList(linkedListTrainingClass);
        System.out.println("Linked List size() = " + doubleListInteger.size());
        System.out.println("Linked List Training class size() = " + linkedListTrainingClass.size());

        System.out.println("Linked List addLast(0)");
        doubleListInteger.addLast(0);
        printList(doubleListInteger);
        System.out.println("Linked List Training class addLast(0)");
        linkedListTrainingClass.addLast(0);
        printList(linkedListTrainingClass);

        System.out.println("Linked List size() = " + doubleListInteger.size());
        System.out.println("Linked List Training class size() = " + linkedListTrainingClass.size());

        System.out.println("Linked List peekedFirst() = " + doubleListInteger.peekFirst());
        System.out.println("Linked List Training class peekedFirst() = " + linkedListTrainingClass.peekFirst());

        System.out.println("Linked List peekedLast() = " + doubleListInteger.peekLast());
        System.out.println("Linked List Training class peekedLast() = " + linkedListTrainingClass.peekLast());

        System.out.println("Empty the list");
        while (!doubleListInteger.isEmpty()) {
            System.out.println("Linked List removeFirst() = " + doubleListInteger.removeFirst());
            System.out.println("Linked List removeLast() = " + doubleListInteger.removeLast());
        }

        System.out.println("Empty the list training");
        while (!linkedListTrainingClass.isEmpty()) {
            System.out.println("Linked List removeFirst() = " + linkedListTrainingClass.removeFirst());
            System.out.println("Linked List removeLast() = " + linkedListTrainingClass.removeLast());
        }
        //== expect exception ==
        //doubleListInteger.peekLast();

    }

    private static void initList(LinkedList<Integer> list) {
        System.out.println("Init 10 random integer... ");
        for (int i = 0; i < 10; i++) {
            Integer integer = new Random().nextInt(50);
            list.addLast(integer);
        }
    }

    private static void printList(LinkedList<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        System.out.print(" with " + list.size() + " integers = ");
        while (iterator.hasNext()) {
            System.out.print(" " + iterator.next());
        }
        System.out.println();
    }
}
