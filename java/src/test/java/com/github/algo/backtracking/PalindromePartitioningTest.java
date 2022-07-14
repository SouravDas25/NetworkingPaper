package com.github.algo.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PalindromePartitioningTest {

    @Test
    void partition() {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        List<List<String>> aab = palindromePartitioning.partition("aab");
        System.out.println(aab);
    }
}