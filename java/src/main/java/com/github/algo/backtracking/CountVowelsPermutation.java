package com.github.algo.backtracking;

import org.javatuples.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountVowelsPermutation {

    private static final int M = 1000000007;
    private static Map<Integer, Integer> cache = new HashMap<>();
    private static long[] lastRow = {1, 1, 1, 1, 1};
    private static long[] newRow = new long[5];
    private static int lastN = 0;

    static {
        cache.put(0, 1);
        cache.put(1, 5);
    }

    public int countVowelPermutation(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        for (int i = lastN + 1; i < n; i++) {
            newRow[0] = lastRow[1] % M;
            newRow[1] = (lastRow[0] + lastRow[2]) % M;
            newRow[2] = (lastRow[0] + lastRow[1] + lastRow[3] + lastRow[4]) % M;
            newRow[3] = (lastRow[2] + lastRow[4]) % M;
            newRow[4] = lastRow[0] % M;
            lastN = i;
            long[] tmp = lastRow;
            lastRow = newRow;
            newRow = tmp;
            System.out.println(Arrays.toString(lastRow));
            cache.put(lastN + 1, (int) ((lastRow[0] + lastRow[1] + lastRow[2] + lastRow[3] + lastRow[4]) % M));
        }
        return cache.get(n);
    }
}
