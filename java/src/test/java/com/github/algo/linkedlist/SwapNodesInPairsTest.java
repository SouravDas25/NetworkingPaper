package com.github.algo.linkedlist;

import org.junit.jupiter.api.Test;

class SwapNodesInPairsTest {

    @Test
    void swapPairs() {
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        LinkedList<Integer> integerDoublyLinkedList = LinkedList.newList(1, 2, 3);
        System.out.println(integerDoublyLinkedList);
        integerDoublyLinkedList.head = swapNodesInPairs.swapPairs(integerDoublyLinkedList.head);
        System.out.println(integerDoublyLinkedList);
    }
}