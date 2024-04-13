package com.github.algo.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                String sub = s.substring(j, i + 1);
                if (set.contains(sub)) {
                    dp[j] = dp[j] || dp[j + sub.length()];
                }
            }
        }
        return dp[0];
    }
}
