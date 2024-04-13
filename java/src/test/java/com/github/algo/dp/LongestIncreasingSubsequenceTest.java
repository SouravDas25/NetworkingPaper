package com.github.algo.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestIncreasingSubsequenceTest {

    @Test
    void lengthOfLIS() {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int i = lis.lengthOfLIS(new int[]{10, 9, 2, 5, 7, 101, 18});
        assertEquals(4, i);
    }

    @Test
    void lengthOfLIS1() {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int i = lis.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6});
        assertEquals(6, i);
    }
}