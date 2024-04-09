package com.github.algo.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListTest {

    @Test
    void reverseList() {
        ReverseLinkedList list = new ReverseLinkedList();
        LinkedList<Integer> ll = LinkedList.newList(1, 2, 3, 4, 5);
        ll.head = list.reverseList(ll.head);
        String string = LinkedList.toString(ll.head);
        System.out.println(string);
    }
}