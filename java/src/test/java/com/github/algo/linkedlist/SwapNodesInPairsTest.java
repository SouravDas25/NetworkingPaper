package com.github.algo.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwapNodesInPairsTest {

    @Test
    void swapPairs() {
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        LinkedList<Integer> integerLinkedList = LinkedList.newList(1, 2, 3);
        System.out.println(integerLinkedList);
        integerLinkedList.head = swapNodesInPairs.swapPairs(integerLinkedList.head);
        System.out.println(integerLinkedList);
    }
}