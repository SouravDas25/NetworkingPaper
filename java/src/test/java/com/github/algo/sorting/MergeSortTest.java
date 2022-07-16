package com.github.algo.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void sort() {
        MergeSort mergeSort = new MergeSort();
        Integer[] ints = {2, 3, 7, 4, 9, 1, 4, 6, 0, 9};
        mergeSort.sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}