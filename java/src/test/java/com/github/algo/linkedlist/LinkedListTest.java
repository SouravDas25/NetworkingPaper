package com.github.algo.linkedlist;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void newList() {
        LinkedList<Integer> integerLinkedList = LinkedList.newList(1, 2, 3, 4, 7, 5, 6);
//        System.out.println(integerLinkedList);
        assertThat(integerLinkedList.toString()).isEqualTo("[1, 2, 3, 4, 7, 5, 6]");
        integerLinkedList.prepend(8);
        assertThat(integerLinkedList.toString()).isEqualTo("[8, 1, 2, 3, 4, 7, 5, 6]");
        integerLinkedList.removeFirst();
        assertThat(integerLinkedList.toString()).isEqualTo("[1, 2, 3, 4, 7, 5, 6]");

        integerLinkedList.removeLast();
        assertThat(integerLinkedList.toString()).isEqualTo("[1, 2, 3, 4, 7, 5]");

        integerLinkedList = LinkedList.newList(1, 2);
        integerLinkedList.removeLast();
        assertThat(integerLinkedList.toString()).isEqualTo("[1]");
        integerLinkedList.removeLast();
        assertThat(integerLinkedList.toString()).isEqualTo("[]");
        integerLinkedList.append(2);
        integerLinkedList.append(3);
        assertThat(integerLinkedList.toString()).isEqualTo("[2, 3]");

        integerLinkedList.removeFirst();
        assertThat(integerLinkedList.toString()).isEqualTo("[3]");
        integerLinkedList.removeFirst();
        assertThat(integerLinkedList.toString()).isEqualTo("[]");

        integerLinkedList.append(2);
        integerLinkedList.append(3);
        assertThat(integerLinkedList.toString()).isEqualTo("[2, 3]");
    }
}