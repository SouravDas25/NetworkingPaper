package com.github.algo.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInsertPositionTest {

    @Test
    void searchInsert() {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int i = searchInsertPosition.searchInsert(new int[]{1, 3, 5, 6}, 9);
        System.out.println(i);
    }
}