package com.github.algo.graph;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CourseScheduleIITest {

    @Test
    void findOrder() {
        CourseScheduleII courseScheduleII = new CourseScheduleII();
        int[][] prequisize = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] order = courseScheduleII.findOrder(4, prequisize);
        System.out.println(Arrays.toString(order));
    }
}