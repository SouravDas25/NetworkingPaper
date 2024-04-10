package com.github.algo.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinCostClimbingStairsTest {

    @Test
    void minCostClimbingStairs() {
        MinCostClimbingStairs m = new MinCostClimbingStairs();
        int i = m.minCostClimbingStairs(new int[]{10, 15, 20});
        assertEquals(15, i);
    }
}