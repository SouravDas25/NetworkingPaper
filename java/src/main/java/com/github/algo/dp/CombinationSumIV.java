package com.github.algo.dp;

import java.util.Arrays;

public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        if (nums.length < 1) {
            return 0;
        }
        int max = Arrays.stream(nums).max().getAsInt();
        int[] dp = new int[target + max + 1];
        for (int n : nums) {
            dp[n] = 1;
        }
        for (int i = 0; i < target; i++) {
            if (dp[i] < 1) continue;
            for (int n : nums) {
                dp[n + i] = dp[n + i] + dp[i];
            }
        }
        return dp[target];
    }

}
