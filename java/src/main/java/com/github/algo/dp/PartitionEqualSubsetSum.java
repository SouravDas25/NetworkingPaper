package com.github.algo.dp;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int target = sum / 2;
        if (sum % 2 != 0) {
            return false;
        }
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        dp[0][0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int amt = 0; amt <= target; amt++) {
                if (amt < nums[i]) {
                    dp[i + 1][amt] = dp[i][amt];
                } else {
                    dp[i + 1][amt] = dp[i][amt] || dp[i][amt - nums[i]];
                }
            }
        }
        return dp[nums.length][target];
    }
}
