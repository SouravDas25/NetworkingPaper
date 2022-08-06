package com.github.algo.linkedlist;

import java.util.List;

public class DeleteNodeLinkedList {

    public void deleteNode(ListNode node) {
        ListNode current = node;
        ListNode previous = null;
        while (current != null) {
            previous = current;
            current = current.next;
            if (current != null) {
                previous.value = current.value;
            }
        }
        previous.next = null;
    }

}
