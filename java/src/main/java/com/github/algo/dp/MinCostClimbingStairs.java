package com.github.algo.dp;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int a = 0, b = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            int currentCost = cost[i] + Math.min(a, b);
            b = a;
            a = currentCost;
        }
        return  Math.min(a, b);
    }

}
