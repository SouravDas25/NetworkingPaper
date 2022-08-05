package com.github.algo.linkedlist;

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode current = head;
        ListNode middle = head;
        int count = 0;
        while (current != null) {
            count++;
            if (count % 2 == 0) {
                middle = middle.next;
            }
            current = current.next;
        }
        return middle;
    }

}
