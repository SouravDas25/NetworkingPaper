package com.github.algo.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestRectangleInHistogramTest {

    @Test
    void largestRectangleArea() {
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        int i = largestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        assertEquals(10, i);
    }
}