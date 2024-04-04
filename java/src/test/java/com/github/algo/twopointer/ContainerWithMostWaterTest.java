package com.github.algo.twopointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {

    @Test
    void maxArea() {
        ContainerWithMostWater container = new ContainerWithMostWater();
        int i = container.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        assertEquals(i, 49);
    }
}