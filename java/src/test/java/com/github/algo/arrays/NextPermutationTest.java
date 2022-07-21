package com.github.algo.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class NextPermutationTest {

    @Test
    void nextPermutation() {
        NextPermutation nextPermutation = new NextPermutation();
        int[] ints = {1, 2, 3};
        nextPermutation.nextPermutation(ints);
        System.out.println(Arrays.toString(ints));
    }
}