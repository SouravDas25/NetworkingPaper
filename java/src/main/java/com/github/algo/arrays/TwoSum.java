package com.github.algo.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numSet = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (numSet.containsKey(diff) && i != numSet.get(diff)) {
                return new int[]{i, numSet.get(diff)};
            }
            numSet.put(nums[i], i);
        }
        return new int[0];
    }

}
