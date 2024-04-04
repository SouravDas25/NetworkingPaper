package com.github.algo.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @Test
    void twoSum() {
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ints));

        ints = twoSum.twoSum(new int[]{3,2,4}, 6);
        System.out.println(Arrays.toString(ints));
    }
}