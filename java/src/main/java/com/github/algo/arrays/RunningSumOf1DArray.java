package com.github.algo.arrays;

public class RunningSumOf1DArray {

    public int[] runningSum(int[] nums) {
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 < 0)
                output[i] = nums[i];
            else
                output[i] = output[i - 1] + nums[i];
        }
        return output;
    }

}
