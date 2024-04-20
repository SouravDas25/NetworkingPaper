package com.github.algo.dp;

import java.util.Arrays;

public class JumpGameII {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE - 1;
            for (int j = 1; j <= Math.min(nums[i], n - 1); j++) {
                int index = i + j;
                if (index < n) {
                    dp[i] = Math.min(dp[i], dp[index] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
}
