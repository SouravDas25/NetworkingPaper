package com.github.algo.arrays;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSumClosestTest {

    @Test
    void threeSumClosest() {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        Integer[] array = Arrays.array(-1, 2, 1, -4);
        int i = threeSumClosest.threeSumClosest(array, 1);
        System.out.println(i);
    }
}