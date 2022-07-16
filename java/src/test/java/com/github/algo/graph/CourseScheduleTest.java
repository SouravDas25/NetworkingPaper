package com.github.algo.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseScheduleTest {

    @Test
    void canFinish() {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        CourseSchedule courseSchedule = new CourseSchedule();
        boolean b = courseSchedule.canFinish(numCourses, prerequisites);
        System.out.println(b);
    }
}