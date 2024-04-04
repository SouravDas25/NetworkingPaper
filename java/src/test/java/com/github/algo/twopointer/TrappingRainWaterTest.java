package com.github.algo.twopointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrappingRainWaterTest {

    @Test
    void trap() {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int trap = trappingRainWater.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        assertEquals(6, trap);

        trap = trappingRainWater.trap(new int[]{4, 2, 3});
        assertEquals(1, trap);
    }
}