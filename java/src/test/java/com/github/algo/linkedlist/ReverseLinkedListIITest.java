package com.github.algo.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListIITest {

    @Test
    void reverseBetween() {
        LinkedList<Integer> linkedList = LinkedList.newList(1,2,3,4,5);
        ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
        linkedList.head = reverseLinkedListII.reverseBetween(linkedList.head, 2, 3);
        System.out.println(linkedList);
    }
}