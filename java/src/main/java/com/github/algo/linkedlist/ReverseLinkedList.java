package com.github.algo.linkedlist;

public class ReverseLinkedList {
    public <T> ListNode<T> reverseList(ListNode<T> head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
