package com.github.algo.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class SplitLinkedListParts {

    private ListNode covertToLinkedList(List<Integer> sublist) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        for (int i = 0; i < sublist.size(); i++) {
            current.next = new ListNode(sublist.get(i));
            current = current.next;
        }
        return head.next;
    }

    public ListNode[] splitListToParts(ListNode<Integer> head, int k) {
        List<Integer> nums = new ArrayList<>();
        ListNode<Integer> current = head;
        while (current != null) {
            nums.add(current.value);
            current = current.next;
        }
        int mod = nums.size() % k;
        int div = nums.size() / k;
        ListNode[] listNodes = new ListNode[k];
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (i < mod) {
                listNodes[i] = covertToLinkedList(nums.subList(count, count + div + 1));
                count += div + 1;
            } else {
                listNodes[i] = covertToLinkedList(nums.subList(count, count + div));
                count += div;
            }
        }
        return listNodes;
    }

}
