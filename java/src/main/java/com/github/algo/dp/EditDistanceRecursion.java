package com.github.algo.dp;

import java.util.*;

public class EditDistanceRecursion {

    private Map<String, Integer> cache = new HashMap<>();
    private String word1 = "";
    private String word2 = "";

    private int dfs(int i, int j) {
        if (i >= word1.length()) {
            return word2.length() - j;
        }
        if (j >= this.word2.length()) {
            return word1.length() - i;
        }
        String key = String.format("%d,%d", i, j);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int a;
        if (word1.charAt(i) == word2.charAt(j)) {
            a = dfs(i + 1, j + 1);
        } else {
            List<Integer> ans = new ArrayList<>();
            ans.add(dfs(i + 1, j));
            ans.add(dfs(i + 1, j + 1));
            ans.add(dfs(i, j + 1));
            a = Collections.min(ans) + 1;
        }
        cache.put(key, a);
        return a;
    }

    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        return dfs(0, 0);
    }

}
