package com.github.algo.arrays;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int p = 1;
        for (int i = 0; i < nums.length; i++) {
            output[i] = p;
            p *= nums[i];
        }
        p = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] *= p;
            p *= nums[i];
        }
        return output;
    }

}
