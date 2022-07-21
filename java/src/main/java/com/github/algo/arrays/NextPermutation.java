package com.github.algo.arrays;

import com.google.common.collect.Comparators;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int changePoint = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                changePoint = i - 1;
                break;
            }
        }
        if (changePoint == -1) {
            Arrays.sort(nums);
        } else {
            int swapWith = changePoint + 1;
            for (int i = changePoint + 2; i < nums.length; i++) {
                if (nums[i] < nums[swapWith] && nums[i] > nums[changePoint]) {
                    swapWith = i;
                }
            }
            int tmp = nums[changePoint];
            nums[changePoint] = nums[swapWith];
            nums[swapWith] = tmp;
            Arrays.sort(nums, changePoint + 1, nums.length);
        }
    }
}
