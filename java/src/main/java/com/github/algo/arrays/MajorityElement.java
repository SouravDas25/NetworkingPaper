package com.github.algo.arrays;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int maxCount = 1;
        int majorityElement = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majorityElement) {
                maxCount++;
            } else {
                maxCount--;
            }
            if (maxCount == 0) {
                maxCount = 1;
                majorityElement = nums[i];
            }
        }
        return majorityElement;
    }
}
