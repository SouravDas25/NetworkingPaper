package com.github.algo.dp;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubmatricesThatSum2Target {

    private int getValue(int i, int j, int rc, int cc, int[][] matrix, Map<String, Integer> cache) {
        if (rc == 1 && cc == 1) {
            return matrix[i][j];
        }
        String key = String.format("%d%d%d%d", i, j, rc, cc);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int v;
        if (cc > rc) {
            v = getValue(i, j, rc, cc - 1, matrix, cache) + getValue(i, j + cc - 1, rc, 1, matrix, cache);
        } else {
            v = getValue(i, j, rc - 1, cc, matrix, cache) + getValue(i + rc - 1, j, 1, cc, matrix, cache);
        }
        cache.put(key, v);
        return v;
    }

    private int dfs(int rc, int cc, int[][] matrix, int target, Map<String, Integer> cache) {
        int count = 0;
        for (int i = 0; i + rc <= matrix.length; i++) {
            for (int j = 0; j + cc <= matrix[i].length; j++) {
                int value = getValue(i, j, rc, cc, matrix, cache);
                if (value == target) count++;
            }
        }
        return count;
    }

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int count = 0;
        Map<String, Integer> cache = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                count += dfs(i + 1, j + 1, matrix, target, cache);
            }
        }
        return count;
    }

}
