package com.github.algo.dp;

import java.util.HashMap;
import java.util.Map;

public class DecodeWaysII {
    static int mod = 1000000007;

    private long dfs(int i, String string, Map<Integer, Long> cache) {
        if (i >= string.length()) {
            return 1;
        }
        if (string.charAt(i) == '0') {
            return 0;
        }
        if (cache.containsKey(i)) {
            return cache.get(i);
        }
        long ways = 0;
        if (string.charAt(i) != '*') {
            ways = dfs(i + 1, string, cache) % mod;
            if (i + 1 < string.length()) {
                if (string.charAt(i + 1) != '*') {
                    if (Integer.parseInt(string.substring(i, i + 2)) <= 26) {
                        ways += dfs(i + 2, string, cache) % mod;
                    }
                } else {
                    if (string.charAt(i) == '1') {
                        ways += (dfs(i + 2, string, cache) * 9) % mod;
                    } else if (string.charAt(i) == '2') {
                        ways += (dfs(i + 2, string, cache) * 6) % mod;
                    }
                }
            }
        } else {
            ways = (dfs(i + 1, string, cache) * 9) % mod;
            if (i + 1 < string.length()) {
                if (string.charAt(i + 1) != '*') {
                    Integer b = Integer.parseInt(String.valueOf(string.charAt(i + 1)));
                    if (b >= 0 && b <= 6) {
                        ways += (dfs(i + 2, string, cache) * 2) % mod;
                    }
                    if (b > 6 && b <= 9) {
                        ways += dfs(i + 2, string, cache) % mod;
                    }
                } else {
                    ways += (dfs(i + 2, string, cache) * 15) % mod;
                }
            }
        }

        cache.put(i, ways);
        return ways;
    }

    public int numDecodings(String s) {
        Map<Integer, Long> cache = new HashMap<>();
        Long val = dfs(0, s, cache) % mod;
        return val.intValue();
    }
}
