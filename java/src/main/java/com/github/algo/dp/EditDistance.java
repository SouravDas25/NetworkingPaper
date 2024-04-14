package com.github.algo.dp;

public class EditDistance {

    public int minDistance(String fromWord, String toWord) {
        int[][] dp = new int[toWord.length() + 1][fromWord.length() + 1];
        dp[toWord.length()][fromWord.length()] = 0;
        for (int i = toWord.length() - 1; i >= 0; i--) {
            dp[i][fromWord.length()] = dp[i + 1][fromWord.length()] + 1;
        }
        for (int i = fromWord.length() - 1; i >= 0; i--) {
            dp[toWord.length()][i] = dp[toWord.length()][i + 1] + 1;
        }
        for (int i = toWord.length() - 1; i >= 0; i--) {
            for (int j = fromWord.length() - 1; j >= 0; j--) {
                if (toWord.charAt(i) == fromWord.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.min(
                            Math.min(
                                    dp[i + 1][j],
                                    dp[i][j + 1]
                            ),
                            dp[i + 1][j + 1]
                    ) + 1;
                }
            }
        }
        return dp[0][0];
    }
}
