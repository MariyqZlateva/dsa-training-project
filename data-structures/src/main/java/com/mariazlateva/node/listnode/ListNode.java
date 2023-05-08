package com.mariazlateva.node.listnode;

public interface ListNode<T> {

    T getValue();

    void setValue(T value);

    ListNode<T> getNext();

    void setNext(ListNode<T> node);

    ListNode<T> getPrevious();

    void setPrevious(ListNode<T> node);

}
