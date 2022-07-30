package com.github.algo.dp;

import java.util.Arrays;

public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[p.length()][s.length()] = true;
        for (int i = p.length() - 1; i >= 0; i--) {
            dp[i][s.length()] = p.charAt(i) == '*' && dp[i + 1][s.length()];
        }
        for (int i = p.length() - 1; i >= 0; i--) {
            for (int j = s.length() - 1; j >= 0; j--) {
                if (p.charAt(i) == '*') {
                    dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
                } else {
                    if (p.charAt(i) == '?' || p.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        Arrays.stream(dp).map(Arrays::toString).forEach(System.out::println);
        return dp[0][0];
    }

}
