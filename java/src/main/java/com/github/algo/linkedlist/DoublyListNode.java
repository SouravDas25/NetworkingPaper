package com.github.algo.linkedlist;

public class DoublyListNode<T> {

    protected T value;
    protected DoublyListNode<T> next = null;
    protected DoublyListNode<T> previous = null;

    public DoublyListNode(T value) {
        this.value = value;
    }

    public DoublyListNode(T value, DoublyListNode<T> next, DoublyListNode<T> previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }
}
