package com.github.algo.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonSubsequenceTest {

    @Test
    void longestCommonSubsequence() {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        int i = longestCommonSubsequence.longestCommonSubsequence("abcde", "ace");
        System.out.println(i);
    }
}