package com.github.algo.arrays;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(Integer[] nums, int target) {
        int ans = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (target == sum) {
                    return sum;
                }
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }
}
