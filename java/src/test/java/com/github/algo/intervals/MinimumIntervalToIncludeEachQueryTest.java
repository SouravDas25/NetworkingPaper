package com.github.algo.intervals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MinimumIntervalToIncludeEachQueryTest {

    @Test
    void minInterval() {
        MinimumIntervalToIncludeEachQuery mi = new MinimumIntervalToIncludeEachQuery();
        int[][] intervals = new int[][]{{1, 4}, {2, 4}, {3, 6}, {4, 4}};
        int[] quries = new int[]{2, 3, 4, 5};
        int[] ints = mi.minInterval(intervals, quries);
        System.out.println(Arrays.toString(ints));
        assertArrayEquals(new int[]{3, 3, 1, 4}, ints);
    }

    @Test
    void minInterval1() {
        MinimumIntervalToIncludeEachQuery mi = new MinimumIntervalToIncludeEachQuery();
        int[][] intervals = new int[][]{{2, 3}, {2, 5}, {1, 8}, {20, 25}};
        int[] quries = new int[]{2, 19, 5, 22};
        int[] ints = mi.minInterval(intervals, quries);
        System.out.println(Arrays.toString(ints));
        assertArrayEquals(new int[]{2, -1, 4, 6}, ints);
    }
}