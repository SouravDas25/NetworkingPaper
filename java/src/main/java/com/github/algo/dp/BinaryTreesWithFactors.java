package com.github.algo.dp;

import java.util.*;
import java.util.stream.Collectors;

public class BinaryTreesWithFactors {

    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        long[] dp = new long[arr.length];
        Map<Integer, Integer> nums = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            nums.put(arr[i], i);
        }
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && nums.containsKey(arr[i] / arr[j])) {
                    int k = arr[i] / arr[j];
                    dp[i] += dp[nums.get(k)] * dp[j];
                }
            }
        }
        return Arrays.stream(dp).boxed().reduce(0L, (a,b) -> (a+b) % 1000000007 ).intValue();
    }

}
