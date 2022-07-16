package com.github.algo.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void sort() {
        QuickSort quickSort = new QuickSort();
        Integer[] ints = {2, 3, 7, 4,27, 9, 1, 4, 6, 0, 9};
        quickSort.sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}