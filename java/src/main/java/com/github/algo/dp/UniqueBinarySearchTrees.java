package com.github.algo.dp;

public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int[] dp = new int[Math.max(4, n + 1)];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        for (int i = 4; i < n + 1; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

}
