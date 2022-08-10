package com.github.algo.linkedlist;

import org.junit.jupiter.api.Test;

class ReverseLinkedListIITest {

    @Test
    void reverseBetween() {
        LinkedList<Integer> list = LinkedList.newList(1, 2, 3, 4, 5);
        ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
        list.head = reverseLinkedListII.reverseBetween(list.head, 1, 5);
        System.out.println(list);
    }
}