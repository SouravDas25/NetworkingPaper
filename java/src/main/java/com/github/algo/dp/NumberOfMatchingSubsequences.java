package com.github.algo.dp;

public class NumberOfMatchingSubsequences {
    private int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text2.length() + 1][text1.length() + 1];
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

    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        for (String word : words) {
            if (longestCommonSubsequence(s, word) == word.length()) {
                count++;
            }
        }
        return count;
    }

}
