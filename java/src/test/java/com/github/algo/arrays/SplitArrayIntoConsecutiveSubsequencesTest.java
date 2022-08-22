package com.github.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SplitArrayIntoConsecutiveSubsequencesTest {

    @Test
    void isPossible() {
        SplitArrayIntoConsecutiveSubsequences splitArrayIntoConsecutiveSubsequences = new SplitArrayIntoConsecutiveSubsequences();
        boolean possible = splitArrayIntoConsecutiveSubsequences.isPossible(new int[]{1,2,3,3,4,4,5,5});
        System.out.println(possible);
    }
}