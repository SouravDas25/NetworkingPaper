package com.github.algo.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TargetSumTest {

    @Test
    void findTargetSumWays() {
        TargetSum targetSum = new TargetSum();
        int targetSumWays = targetSum.findTargetSumWays(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 3);
        System.out.println(targetSumWays);
    }
}