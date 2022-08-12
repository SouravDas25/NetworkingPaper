package com.github.algo.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SplitLinkedListPartsTest {

    @Test
    void splitListToParts() {
        SplitLinkedListParts splitLinkedListParts = new SplitLinkedListParts();
        LinkedList<Integer> linkedList = LinkedList.newList(1, 2, 3);
        ListNode[] listNodes = splitLinkedListParts.splitListToParts(linkedList.head, 5);
        Arrays.stream(listNodes).map(LinkedList::toString).forEach(System.out::println);
    }
}