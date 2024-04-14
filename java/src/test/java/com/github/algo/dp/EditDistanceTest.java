package com.github.algo.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditDistanceTest {

    @Test
    void minDistance() {
        EditDistance ed = new EditDistance();
        int i = ed.minDistance("horse", "ros");
        assertEquals(3, i);
    }
}