package com.github.algo.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OddEvenLinkedListTest {

    @Test
    void oddEvenList() {
        LinkedList<Integer> linkedList= LinkedList.newList(2);
        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
        linkedList.head = oddEvenLinkedList.oddEvenList(null);
        System.out.println(linkedList);
    }
}