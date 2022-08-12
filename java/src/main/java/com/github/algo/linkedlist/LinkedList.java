package com.github.algo.linkedlist;

public class LinkedList<T> {

    protected ListNode<T> head = null;
    protected ListNode<T> tail = null;
    protected int size = 0;

    public int size() {
        return size;
    }

    public void append(T value) {
        ListNode<T> newNode = new ListNode<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void prepend(T value) {
        if (head == null) {
            append(value);
        } else {
            ListNode<T> newNode = new ListNode<>(value);
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    public T removeLast() {
        if (size > 0) {
            ListNode<T> removeNode = tail;
            if (tail != null) {
                tail.next = null;
            }
            size--;
            if (size <= 0) {
                head = null;
            }
            return removeNode.value;
        }
        return null;
    }

    public T removeFirst() {
        if (size > 0) {
            ListNode<T> removeNode = head;
            head = head.next;
            size--;
            if (size <= 0) {
                tail = null;
            }
            return removeNode.value;
        }
        return null;
    }

    @SafeVarargs
    public static <T> LinkedList<T> newList(T... values) {
        LinkedList<T> list = new LinkedList<>();
        for (T value : values) {
            list.append(value);
        }
        return list;
    }

    public static String toString(ListNode node) {
        StringBuilder sb = new StringBuilder();
        ListNode current = node;
        sb.append("[");
        while (current != null) {
            sb.append(current.value);
            current = current.next;
            if (current != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    @Override
    public String toString() {
        return LinkedList.toString(this.head);
    }

}
