package com.github.algo.linkedlist;

public class AlternateReverse {

    ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();

    public int count(ListNode head) {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public <T> ListNode<T> reverse(ListNode<T> head) {
        int size = count(head);
        for (int i = 0; i < size / 2; i++) {
            head = reverseLinkedListII.reverseBetween(head, i + 1, size - i);
        }
        return head;
    }


}
