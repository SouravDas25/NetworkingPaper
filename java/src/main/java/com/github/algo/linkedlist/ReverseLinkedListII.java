package com.github.algo.linkedlist;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode current = head;
        ListNode previous = null;
        if(left <= 0) left = 1;
        int count = 0;
        while (current.next != null) {
            count++;
            if (count >= left) {
                break;
            }
            previous = current;
            current = current.next;
        }
        if(current.next == null) {
            return head;
        }
        ListNode<Integer> current2 = current;
        ListNode<Integer> pv2 = null;
        ListNode<Integer> next = current.next;
        while (count < right && next != null) {
            ListNode<Integer> nextN = next.next;
            current.next = pv2;
            next.next = current;
            pv2 = current;
            current = next;
            next = nextN;
            count++;
        }
        if (previous == null) {
            head = current;
        } else {
            previous.next = current;
        }
        current2.next = next;
        return head;
    }
}
