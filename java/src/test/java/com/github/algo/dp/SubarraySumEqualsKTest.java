package com.github.algo.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubarraySumEqualsKTest {

    @Test
    void subarraySum() {
        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        int i = subarraySumEqualsK.subarraySum(new int[]{1, 1, 1}, 2);
        System.out.println(i);
    }
}