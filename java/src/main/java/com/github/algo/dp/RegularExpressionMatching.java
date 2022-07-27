package com.github.algo.dp;

import com.github.algo.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class RegularExpressionMatching {

    private List<Pair<Character, Integer>> compile(String pattern) {
        List<Pair<Character, Integer>> output = new ArrayList<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == '*') {
                output.set(output.size() - 1, Pair.with(pattern.charAt(i - 1), -1));
            } else {
                output.add(Pair.with(pattern.charAt(i), 1));
            }
        }
        return output;
    }

    public boolean isMatch(String s, String p) {
        if (p.length() <= 0) {
            return s.length() == p.length();
        }
        List<Pair<Character, Integer>> pattern = compile(p);
        boolean[][] dp = new boolean[pattern.size() + 1][s.length() + 1];
        System.out.println(pattern);
        dp[pattern.size()][s.length()] = true;
        for (int i = pattern.size() - 1; i >= 0; i--) {
            dp[i][s.length()] = pattern.get(i).getValue1() == -1 && dp[i + 1][s.length()];
        }
        for (int i = pattern.size() - 1; i >= 0; i--) {
            for (int j = s.length() - 1; j >= 0; j--) {
                Pair<Character, Integer> pair = pattern.get(i);
                int count = pair.getValue1();
                char ch = pair.getValue0();
                if (count == 1) {
                    if (ch == '.' || s.charAt(j) == ch) {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (ch == '.' || s.charAt(j) == ch) {
                        dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
                    } else {
                        dp[i][j] = dp[i + 1][j];
                    }
                }
            }
        }
        Arrays.stream(dp).map(Arrays::toString).forEach(System.out::println);
        return dp[0][0];
    }
}
