package com.mariazlateva.list.linkedlist.impl;

import com.mariazlateva.iterator.Iterator;
import com.mariazlateva.iterator.impl.ListIterator;
import com.mariazlateva.list.linkedlist.LinkedList;
import com.mariazlateva.node.listnode.ListNode;
import com.mariazlateva.node.listnode.impl.ListNodeImpl;

import java.util.NoSuchElementException;

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
        if (isEmpty()) {
            head = new ListNodeImpl<>(item);
            tail = head;
        } else {
            ListNode<T> newNode = new ListNodeImpl<>(item);
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        if (isEmpty()) {
            tail = new ListNodeImpl<>(item);
            head = tail;
        } else {
            ListNode<T> newNode = new ListNodeImpl<>(item);
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        ListNode<T> removed = head;
        head = head.getNext();
        removed.setNext(null);
        if (head != null) {
            head.setPrevious(null);
        }
        size--;
        return removed.getValue();
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        ListNode<T> removed = tail;
        tail = tail.getPrevious();
        removed.setPrevious(null);
        if (tail != null) {
            tail.setNext(null);
        }
        size--;
        return removed.getValue();
    }

    @Override
    public T peekFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.getValue();
    }

    @Override
    public T peekLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return tail.getValue();
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
