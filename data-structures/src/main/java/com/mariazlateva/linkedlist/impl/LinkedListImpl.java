package com.mariazlateva.linkedlist.impl;

import com.mariazlateva.iterator.Iterator;
import com.mariazlateva.iterator.impl.ListIterator;
import com.mariazlateva.linkedlist.LinkedList;
import com.mariazlateva.node.listnode.ListNode;

public class LinkedListImpl<T> implements LinkedList<T> {

    private ListNode<T> head;
    private ListNode<T> tail;

    private int size;

    public LinkedListImpl() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void addFirst(T item) {

    }

    @Override
    public void addLast(T item) {

    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T peekFirst() {
        return null;
    }

    @Override
    public T peekLast() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(this.head);
    }

}
