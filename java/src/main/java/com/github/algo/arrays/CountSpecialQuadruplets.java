package com.github.algo.arrays;

import com.github.algo.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class CountSpecialQuadruplets {
    public int countQuadruplets(int[] nums) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexMap.put(nums[i], i);
            countMap.put(nums[i], 0);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (indexMap.containsKey(sum) && indexMap.get(sum) > k) {
                        countMap.put(sum, countMap.get(sum) + 1);
                    }
                }
            }
        }
        return countMap.values().stream().reduce(0, Integer::sum);
    }
}
