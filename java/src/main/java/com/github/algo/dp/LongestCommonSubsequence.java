package com.github.algo.dp;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        Arrays.stream(dp).forEach(a -> a[text2.length()] = 0);
        Arrays.fill(dp[text1.length()], 0);

        for (int i = text2.length() - 1; i >= 0; i--) {
            for (int j = text1.length() - 1; j >= 0; j--) {
                if (text2.charAt(i) == text1.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
}
