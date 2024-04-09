package com.github.algo.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInRotatedSortedArrayTest {

    @Test
    void search() {
        SearchInRotatedSortedArray sol = new SearchInRotatedSortedArray();
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int actual = sol.search(arr, target);
        assertEquals(4, actual);
    }

    @Test
    void search2() {
        SearchInRotatedSortedArray sol = new SearchInRotatedSortedArray();
        int[] arr = {5, 1, 3};
        int target = 5;
        int actual = sol.search(arr, target);
        assertEquals(0, actual);
    }

    @Test
    void search3() {
        SearchInRotatedSortedArray sol = new SearchInRotatedSortedArray();
        int[] arr = {3, 1};
        int target = 1;
        int actual = sol.search(arr, target);
        assertEquals(1, actual);
    }
}