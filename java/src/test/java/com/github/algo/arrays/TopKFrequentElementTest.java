package com.github.algo.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TopKFrequentElementTest {

    @Test
    void topKFrequent() {
        TopKFrequentElement topKFrequentElement = new TopKFrequentElement();


        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int[] ints = topKFrequentElement.topKFrequent(nums, 2);
        System.out.println(Arrays.toString(ints));
    }
}