package com.mariazlateva.iterator.impl;

import com.mariazlateva.iterator.Iterator;
import com.mariazlateva.node.listnode.ListNode;

public class ListIterator<T> implements Iterator<T> {

    ListNode<T> head;

    public ListIterator(ListNode<T> head) {
        this.head = head;
    }

    @Override
    public boolean hasNext() {
        return head != null;
    }

    @Override
    public T next() {
        T value = head.getValue();
        head = head.getNext();
        return value;
    }
}
