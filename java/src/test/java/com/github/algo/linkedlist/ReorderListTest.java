package com.github.algo.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReorderListTest {

    @Test
    void reorderList() {
        ReorderList rl = new ReorderList();
        LinkedList list = LinkedList.newList(1, 2, 3, 4, 5);
        rl.reorderList(list.head);
        String string = LinkedList.toString(list.head);
        System.out.println(string);
    }

    @Test
    void reorderList1() {
        ReorderList rl = new ReorderList();
        LinkedList list = LinkedList.newList(1);
        rl.reorderList(list.head);
        String string = LinkedList.toString(list.head);
        System.out.println(string);
    }
}