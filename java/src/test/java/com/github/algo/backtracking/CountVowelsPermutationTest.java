package com.github.algo.backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountVowelsPermutationTest {

    @Test
    void countVowelPermutation() {
        CountVowelsPermutation countVowelsPermutation = new CountVowelsPermutation();
        int i = countVowelsPermutation.countVowelPermutation(1);
        System.out.println(i);
    }
}