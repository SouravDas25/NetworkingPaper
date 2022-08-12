package com.github.algo.linkedlist;

public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        ListNode evenh = new ListNode(0);
        ListNode even = evenh;
        ListNode odd = new ListNode(0);
        ListNode current = head;
        while (current != null) {
            odd.next = current;
            current = current.next;
            odd = odd.next;
            if (current != null) {
                even.next = current;
                current = current.next;
                even = even.next;
            }
        }
        even.next = null;
        odd.next = evenh.next;
        return head;
    }

}
