package com.github.algo.arrays;

import org.junit.jupiter.api.Test;

class MaximumAreaInCakeTest {

    @Test
    void maxArea() {

        MaximumAreaInCake maximumAreaInCake = new MaximumAreaInCake();
        long maxArea = maximumAreaInCake.maxArea(1000000000, 1000000000, new int[]{2}, new int[]{2});
        System.out.println(maxArea);
    }
}