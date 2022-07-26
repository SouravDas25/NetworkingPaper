package com.github.algo.linkedlist;

import java.util.List;

public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        ListNode fp = head, sp = head;
        while (fp != null) {
            sp = sp.next;
            if (fp.next == null) {
                fp = null;
                break;
            }
            fp = fp.next.next;
            if (sp == fp) {
                break;
            }
        }
        if (fp == sp && sp != null) {
            ListNode current = head;
            while (current != sp) {
                current = current.next;
                sp = sp.next;
            }
            return current;
        }
        return null;
    }

}
