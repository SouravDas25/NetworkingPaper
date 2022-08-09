package com.github.algo.arrays;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountSmallerNumbersAfterSelfSegmentTreeTest {

    @Test
    void countSmaller() {
        CountSmallerNumbersAfterSelfSegmentTree c = new CountSmallerNumbersAfterSelfSegmentTree();
        List<Integer> integers = c.countSmaller(new int[]{-1});
        System.out.println(integers);
    }
}