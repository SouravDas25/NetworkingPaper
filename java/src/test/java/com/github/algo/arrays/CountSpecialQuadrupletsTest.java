package com.github.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountSpecialQuadrupletsTest {

    @Test
    void countQuadruplets() {
        int[] nums = {9,6,8,23,39,23};
        CountSpecialQuadruplets countSpecialQuadruplets = new CountSpecialQuadruplets();
        int i = countSpecialQuadruplets.countQuadruplets(nums);
        System.out.println(i);
    }
}