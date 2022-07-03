package com.github.algo.linkedlist;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;

public class LinkedList<T> implements Serializable {

    protected int size = 0;
    protected ListNode<T> head = null;
    protected ListNode<T> tail = null;

    private int size() {
        return size;
    }

    public void append(T value) {
        ListNode<T> newNode = new ListNode<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            size++;
            tail = newNode;
        }
    }

    public void prepend(T value) {
        if (head == null) {
            append(value);
        } else {
            ListNode<T> newNode = new ListNode<>(value);
            head.previous = newNode;
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    public T removeLast() {
        if (size > 0) {
            ListNode<T> removeNode = tail;
            tail = tail.previous;
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
            if (head != null) {
                head.previous = null;
            }
            size--;
            if (size <= 0) {
                tail = null;
            }
            return removeNode.value;
        }
        return null;
    }

    public void forEach(Function<T, Void> lambda) {
        ListNode<T> current = head;
        while (current != null) {
            lambda.apply(current.value);
            current = current.next;
        }
    }

    @SafeVarargs
    public static <T> LinkedList<T> newList(T... values) {
        LinkedList<T> list = new LinkedList<>();
        for (T value : values) {
            list.append(value);
        }
        return list;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode<T> current = head;
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
}
