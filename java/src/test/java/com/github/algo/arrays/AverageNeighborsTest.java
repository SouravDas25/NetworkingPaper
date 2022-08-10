package com.github.algo.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AverageNeighborsTest {

    @Test
    void rearrangeArray() {
        AverageNeighbors averageNeighbors = new AverageNeighbors();
        int[] nums = averageNeighbors.rearrangeArray(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(nums));
    }
}