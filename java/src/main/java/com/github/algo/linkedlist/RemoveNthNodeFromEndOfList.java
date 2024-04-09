package com.github.algo.linkedlist;

public class RemoveNthNodeFromEndOfList {

    int size(ListNode head) {
        ListNode current = head;
        int count = 0;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        int size = size(head);
        ListNode dummy = new ListNode(-1, head);
        ListNode current = dummy;
        for (int i = 0; i < size - n; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        return dummy.next;
    }
}
