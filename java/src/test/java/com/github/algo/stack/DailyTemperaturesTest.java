package com.github.algo.stack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DailyTemperaturesTest {

    @Test
    void dailyTemperatures() {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] ints = dailyTemperatures.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(ints));
        assertArrayEquals(new int[]{1, 1, 4, 2, 1, 1, 0, 0}, ints);

        ints = dailyTemperatures.dailyTemperatures(new int[]{30, 40, 50, 60});
        System.out.println(Arrays.toString(ints));
        assertArrayEquals(new int[]{1, 1, 1, 0}, ints);
    }
}