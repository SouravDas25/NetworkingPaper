package com.github.algo.dp;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    static int mod = 1000000007;

    private int dfs(int i, String string, Map<Integer, Integer> cache) {
        if (i >= string.length()) {
            return 1;
        }
        if (string.charAt(i) == '0') {
            return 0;
        }
        if (cache.containsKey(i)) {
            return cache.get(i);
        }
        int ways = dfs(i + 1, string, cache) % mod;
        if (i + 2 <= string.length() && Integer.parseInt(string.substring(i, i + 2)) <= 26) {
            ways += dfs(i + 2, string, cache) % mod;
        }
        cache.put(i, ways);
        return ways;
    }

    public int numDecodings(String s) {
        Map<Integer, Integer> cache = new HashMap<>();
        return dfs(0, s, cache) % mod;
    }
}
