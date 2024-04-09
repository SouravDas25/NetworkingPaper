package com.github.algo.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskSchedulerTest {

    @Test
    void leastInterval() {
        TaskScheduler taskScheduler = new TaskScheduler();
        int i = taskScheduler.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);
        assertEquals(8, i);
    }

    @Test
    void leastInterval1() {
        TaskScheduler taskScheduler = new TaskScheduler();
        String tasks = "AAAAAABCDEFG";
        int i = taskScheduler.leastInterval(tasks.toCharArray(), 1);
        assertEquals(12, i);
    }
}