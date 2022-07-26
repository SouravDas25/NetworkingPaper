package com.github.algo.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RotateArrayTest {

    @Test
    void rotate() {
        RotateArray rotateArray = new RotateArray();
        int[] nums = new int[]{1,2,3,4,5};
        rotateArray.rotate(nums, 6);
        System.out.println(Arrays.toString(nums));
    }
}