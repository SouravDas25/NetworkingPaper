package com.github.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumProductSubarrayTest {

    @Test
    void maxProduct() {
        int[] nums = {2,3,-2,4};
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        int i = maximumProductSubarray.maxProduct(nums);
        System.out.println(i);
    }
}