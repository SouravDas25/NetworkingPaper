package com.github.algo.mathgeometry;

import java.util.ArrayList;
import java.util.Arrays;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int j = 1;
            while (i + j * j <= n) {
                dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
                j++;
            }
        }
        System.out.println(Arrays.toString(dp));
        //happy
        return dp[n];
    }
}
