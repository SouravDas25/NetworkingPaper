package com.github.algo.linkedlist;

public class ReorderList {

    ListNode midOflist(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;

        }
        return prev;
    }

    ListNode reverse(ListNode head) {
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

    public void reorderList(ListNode head) {
        ListNode b4mid = midOflist(head);
        if (b4mid == null) {
            return;
        }
        ListNode mid = reverse(b4mid.next);
        b4mid.next = null;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (head != null) {
            // capture 1
            curr.next = head;
            head = head.next;
            curr = curr.next;
            // catepure 2
            curr.next = mid;
            mid = mid.next;
            curr = curr.next;
        }
    }
}
