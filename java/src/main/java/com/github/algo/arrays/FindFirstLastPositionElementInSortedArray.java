package com.github.algo.arrays;

import java.util.Arrays;

public class FindFirstLastPositionElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int i = Arrays.binarySearch(nums, target);
        if (i != -1) {
            int left = i, right = i;
            while (0 <= left && nums[left] == target || right < nums.length && nums[right] == target  ) {
                if(0 <= left && nums[left] == target) {
                    left--;
                }
                if(right < nums.length && nums[right] == target) {
                    right++;
                }
            }
            return new int[]{left+1, right-1};
        }
        return new int[]{-1, -1};
    }
}
