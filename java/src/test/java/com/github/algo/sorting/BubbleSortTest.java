package com.github.algo.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void sort() {
        BubbleSort bubbleSort = new BubbleSort();
        Integer[] ints = {2, 3, 7, 4, 9, 1, 4, 6, 0, 9};
        bubbleSort.sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}