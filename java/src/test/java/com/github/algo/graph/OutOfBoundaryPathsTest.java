package com.github.algo.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutOfBoundaryPathsTest {

    @Test
    void findPaths() {
        OutOfBoundaryPaths outOfBoundaryPaths = new OutOfBoundaryPaths();
        long paths = outOfBoundaryPaths.findPaths(8, 50, 23, 5, 26);
        System.out.println(paths);
    }
}