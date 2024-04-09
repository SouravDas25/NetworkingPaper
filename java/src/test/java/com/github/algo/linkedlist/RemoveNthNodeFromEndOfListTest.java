package com.github.algo.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveNthNodeFromEndOfListTest {

    @Test
    void removeNthFromEnd() {
        RemoveNthNodeFromEndOfList removeNthNodeFromEnd = new RemoveNthNodeFromEndOfList();
        LinkedList ll = LinkedList.newList(1, 2, 3, 4, 5);
        ll.head = removeNthNodeFromEnd.removeNthFromEnd(ll.head, 2);
        System.out.println(LinkedList.toString(ll.head));
    }

    @Test
    void removeNthFromEnd1() {
        RemoveNthNodeFromEndOfList removeNthNodeFromEnd = new RemoveNthNodeFromEndOfList();
        LinkedList ll = LinkedList.newList(1, 2);
        ll.head = removeNthNodeFromEnd.removeNthFromEnd(ll.head, 1);
        System.out.println(LinkedList.toString(ll.head));
    }

    @Test
    void removeNthFromEnd2() {
        RemoveNthNodeFromEndOfList removeNthNodeFromEnd = new RemoveNthNodeFromEndOfList();
        LinkedList ll = LinkedList.newList(1);
        ll.head = removeNthNodeFromEnd.removeNthFromEnd(ll.head, 1);
        System.out.println(LinkedList.toString(ll.head));
    }
}