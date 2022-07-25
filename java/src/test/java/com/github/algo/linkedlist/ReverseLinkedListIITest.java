package com.github.algo.linkedlist;

import org.junit.jupiter.api.Test;

class ReverseLinkedListIITest {

    @Test
    void reverseBetween() {
        LinkedList<Integer> doublyLinkedList = LinkedList.newList(1, 2, 3, 4, 5);
        ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
        doublyLinkedList.head = reverseLinkedListII.reverseBetween(doublyLinkedList.head, 2, 3);
        System.out.println(doublyLinkedList);
    }
}