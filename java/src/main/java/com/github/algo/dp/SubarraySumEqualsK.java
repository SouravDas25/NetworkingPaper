package com.github.algo.dp;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 1);
        int currentSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (cache.containsKey(currentSum - k)) {
                count += cache.get(currentSum - k);
            }
            cache.put(currentSum, cache.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }

}
