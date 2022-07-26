package com.github.algo.arrays;

import java.util.Arrays;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        if (nums.length <= 0) return;
        k = k % nums.length;
        if (k == 0) return;
        int[] tmp = Arrays.copyOfRange(nums, nums.length - k, nums.length);
        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < tmp.length; i++) {
            nums[i] = tmp[i];
        }
    }

}
