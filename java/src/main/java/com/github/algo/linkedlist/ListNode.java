package com.github.algo.linkedlist;

public class ListNode<T> {

    protected T value;
    protected ListNode<T> next = null;
    protected ListNode<T> previous = null;

    public ListNode(T value) {
        this.value = value;
    }

    public ListNode(T value, ListNode<T> next, ListNode<T> previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }
}
