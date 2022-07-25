package com.github.algo.linkedlist;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DoublyLinkedListTest {

    @Test
    void newList() {
        DoublyLinkedList<Integer> integerDoublyLinkedList = DoublyLinkedList.newList(1, 2, 3, 4, 7, 5, 6);
//        System.out.println(integerDoublyLinkedList);
        assertThat(integerDoublyLinkedList.toString()).isEqualTo("[1, 2, 3, 4, 7, 5, 6]");
        integerDoublyLinkedList.prepend(8);
        assertThat(integerDoublyLinkedList.toString()).isEqualTo("[8, 1, 2, 3, 4, 7, 5, 6]");
        integerDoublyLinkedList.removeFirst();
        assertThat(integerDoublyLinkedList.toString()).isEqualTo("[1, 2, 3, 4, 7, 5, 6]");

        integerDoublyLinkedList.removeLast();
        assertThat(integerDoublyLinkedList.toString()).isEqualTo("[1, 2, 3, 4, 7, 5]");

        integerDoublyLinkedList = DoublyLinkedList.newList(1, 2);
        integerDoublyLinkedList.removeLast();
        assertThat(integerDoublyLinkedList.toString()).isEqualTo("[1]");
        integerDoublyLinkedList.removeLast();
        assertThat(integerDoublyLinkedList.toString()).isEqualTo("[]");
        integerDoublyLinkedList.append(2);
        integerDoublyLinkedList.append(3);
        assertThat(integerDoublyLinkedList.toString()).isEqualTo("[2, 3]");

        integerDoublyLinkedList.removeFirst();
        assertThat(integerDoublyLinkedList.toString()).isEqualTo("[3]");
        integerDoublyLinkedList.removeFirst();
        assertThat(integerDoublyLinkedList.toString()).isEqualTo("[]");

        integerDoublyLinkedList.append(2);
        integerDoublyLinkedList.append(3);
        assertThat(integerDoublyLinkedList.toString()).isEqualTo("[2, 3]");
    }
}