package com.github.algo.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfMatchingSubsequencesTest {

    @Test
    void numMatchingSubseq() {
        NumberOfMatchingSubsequences numberOfMatchingSubsequences = new NumberOfMatchingSubsequences();
        int abcde = numberOfMatchingSubsequences.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"});
        System.out.println(abcde);
    }
}