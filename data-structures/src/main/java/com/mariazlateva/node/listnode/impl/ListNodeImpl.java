package com.mariazlateva.node.listnode.impl;

import com.mariazlateva.node.listnode.ListNode;

public class ListNodeImpl<T> implements ListNode<T> {

    private T value;
    private ListNode<T> next;
    private ListNode<T> previous;

    public ListNodeImpl(T value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public ListNode<T> getNext() {
        return this.next;
    }

    @Override
    public void setNext(ListNode<T> node) {
        this.next = node;
    }

    @Override
    public ListNode<T> getPrevious() {
        return this.previous;
    }

    @Override
    public void setPrevious(ListNode<T> node) {
        this.previous = node;
    }


    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
