package com.github.algo.linkedlist;

import java.io.Serializable;
import java.util.function.Function;

public class DoublyLinkedList<T> implements Serializable {

    protected int size = 0;
    protected DoublyListNode<T> head = null;
    protected DoublyListNode<T> tail = null;

    public int size() {
        return size;
    }

    public void append(T value) {
        DoublyListNode<T> newNode = new DoublyListNode<>(value);
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
            DoublyListNode<T> newNode = new DoublyListNode<>(value);
            head.previous = newNode;
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    public T removeLast() {
        if (size > 0) {
            DoublyListNode<T> removeNode = tail;
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
            DoublyListNode<T> removeNode = head;
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
        DoublyListNode<T> current = head;
        while (current != null) {
            lambda.apply(current.value);
            current = current.next;
        }
    }

    @SafeVarargs
    public static <T> DoublyLinkedList<T> newList(T... values) {
        DoublyLinkedList<T> list = new DoublyLinkedList<>();
        for (T value : values) {
            list.append(value);
        }
        return list;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DoublyListNode<T> current = head;
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
