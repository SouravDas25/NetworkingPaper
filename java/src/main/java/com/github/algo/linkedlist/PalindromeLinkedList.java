package com.github.algo.linkedlist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode<Integer> current = head;
        List<Integer> list = new ArrayList<>();
        while (current != null) {
            list.add(current.value);
            current = current.next;
        }
        String straight = list.toString();
        Collections.reverse(list);
        return list.toString().equals(straight);
    }
}
