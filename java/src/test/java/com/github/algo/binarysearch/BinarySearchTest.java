package com.github.algo.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void search() {
        BinarySearch binarySearch = new BinarySearch();
        int search = binarySearch.search(new int[]{-1, 0, 3, 5, 9, 12}, 9);
        assertEquals(4, search);
    }
}