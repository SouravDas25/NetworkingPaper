package com.github.algo.arrays;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int[] forwardRunningSum = new int[nums.length + 1];
        int[] backwardRunningSum = new int[nums.length + 1];
        forwardRunningSum[0] = 0;
        backwardRunningSum[nums.length] = 0;
        for (int i = 0; i < nums.length; i++) {
            forwardRunningSum[i + 1] = forwardRunningSum[i] + nums[i];
            backwardRunningSum[nums.length - 1 - i] = backwardRunningSum[nums.length - i] + nums[nums.length - 1 - i];
        }
        int output = -1;
        for (int i = 0; i < nums.length; i++) {
            if (forwardRunningSum[i] == backwardRunningSum[i + 1]) {
                output = i;
                break;
            }
        }
        return output;
    }
}
