package com.mariazlateva.stack.impl;

import com.mariazlateva.iterator.Iterator;
import com.mariazlateva.iterator.impl.ArrayIterator;
import com.mariazlateva.stack.Stack;

import java.util.EmptyStackException;

public class StackImpl<T> implements Stack<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] stack;
    private int top;

    public StackImpl() {
        this(DEFAULT_CAPACITY);
    }

    public StackImpl(int initialCapacity) {
        if (initialCapacity < 1) {
            initialCapacity = DEFAULT_CAPACITY;
        }
        this.stack = new Object[initialCapacity];
        this.top = 0;
    }

    @Override
    public void push(T item) {
        if (this.top == this.stack.length) {
            Object[] stackCopy = new Object[stack.length * 2];
            System.arraycopy(stack, 0, stackCopy, 0, top);
            stack = stackCopy;
        }
        this.stack[top++] = item;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = (T) this.stack[top - 1];
        stack[top - 1] = null;
        top--;
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) this.stack[top - 1];
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public Iterator<T> iterator() {
        Object[] copy = new Object[top];
        for (int stackIndex = top - 1, copyIndex = 0; stackIndex >= 0; stackIndex--, copyIndex++) {
            copy[copyIndex] = this.stack[stackIndex];
        }
        return new ArrayIterator<>(copy);
    }

}
