package com.github.algo.dp;

import com.github.algo.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    private int dfs(int i, int[] nums, int target, Map<Pair<Integer, Integer>, Integer> cache) {
        if (i >= nums.length) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }
        Pair<Integer, Integer> key = Pair.with(i, target);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int ways = 0;
        ways += dfs(i + 1, nums, target - nums[i], cache);
        ways += dfs(i + 1, nums, target + nums[i], cache);
        cache.put(key, ways);
        return ways;
    }

    public int findTargetSumWays(int[] nums, int target) {
        Map<Pair<Integer, Integer>, Integer> cache = new HashMap<>();
        return dfs(0, nums, target, cache);
    }

}
