package com.github.algo.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlternateReverseTest {

    @Test
    void reverse() {
        AlternateReverse alternateReverse = new AlternateReverse();
        LinkedList<Integer> list = LinkedList.newList(1, 2, 3, 4, 5, 6);
        list.head = alternateReverse.reverse(list.head);
        System.out.println(list);
    }
}