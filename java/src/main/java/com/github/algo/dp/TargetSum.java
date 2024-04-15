package com.github.algo.dp;

import com.github.algo.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    record Memo(int i, int target) {
    }

    Map<Memo, Integer> cache = new HashMap<>();
    int[] nums;

    private int dfs(int i, int target) {
        if (i >= nums.length) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }
        Memo key = new Memo(i, target);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int ways = 0;
        ways += dfs(i + 1, target - nums[i]);
        ways += dfs(i + 1, target + nums[i]);
        cache.put(key, ways);
        return ways;
    }

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        return dfs(0, target);
    }

}
