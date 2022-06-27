package com.github.algo.dp;

import java.util.Arrays;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, 0);
        }
        Arrays.fill(dp[t.length()], 1);

        for (int i = t.length() - 1; i >= 0; i--) {
            for (int j = s.length() - 1; j >= 0; j--) {
                if (t.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i][j + 1];
                } else {
                    dp[i][j] = dp[i][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}
