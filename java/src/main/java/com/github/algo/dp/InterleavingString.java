package com.github.algo.dp;

import java.util.Arrays;

public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        if (s1.isEmpty()) {
            return s2.equals(s3);
        }
        if (s2.isEmpty()) {
            return s1.equals(s3);
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[s1.length()][s2.length()] = true;
        int k = s3.length();
        for (int i = s1.length() - 1; i >= 0; i--) {
            k--;
            if (s1.charAt(i) == s3.charAt(k)) {
                dp[i][s2.length()] = dp[i + 1][s2.length()];
            }
        }
        k = s3.length();
        for (int i = s2.length() - 1; i >= 0; i--) {
            k--;
            if (s2.charAt(i) == s3.charAt(k)) {
                dp[s1.length()][i] = dp[s1.length()][i + 1];
            }
        }
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                k = i + j;
                if (s3.length() <= k) {
                    dp[i][j] = true;
                } else if (s1.charAt(i) == s2.charAt(j)) {
                    if (s3.charAt(k) == s2.charAt(j)) {
                        dp[i][j] = dp[i][j + 1] || dp[i + 1][j];
                    } else {
                        dp[i][j] = false;
                    }
                } else if (s1.charAt(i) == s3.charAt(k)) {
                    dp[i][j] = dp[i + 1][j];
                } else if (s2.charAt(j) == s3.charAt(k)) {
                    dp[i][j] = dp[i][j + 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        Arrays.stream(dp).map(Arrays::toString).forEach(System.out::println);
        return dp[0][0];
    }

}
