package com.github.algo.linkedlist;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode current = head;
        ListNode pc = null;
        while (current != null) {
            ListNode N = current.next;
            if (N == null) {
                break;
            }
            ListNode T = N.next;
            N.next = current;
            if (current == head) {
                head = N;
            }
            current.next = T;
            if (pc != null) {
                pc.next = N;
            }
            pc = current;
            current = current.next;
        }
        return head;
    }
}
