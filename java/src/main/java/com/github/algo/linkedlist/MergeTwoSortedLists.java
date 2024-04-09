package com.github.algo.linkedlist;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode<Integer> head1 = list1;
        ListNode<Integer> head2 = list2;
        ListNode cur = head;
        while (head1 != null || head2 != null) {
            if (head1 != null && head2 != null) {
                if (head1.value <= head2.value) {
                    cur.next = head1;
                    head1 = head1.next;
                } else {
                    cur.next = head2;
                    head2 = head2.next;
                }
            } else {
                if (head1 == null) {
                    cur.next = head2;
                    head2 = head2.next;
                } else {
                    cur.next = head1;
                    head1 = head1.next;
                }
            }
            cur = cur.next;
        }
        return head.next;
    }
}
