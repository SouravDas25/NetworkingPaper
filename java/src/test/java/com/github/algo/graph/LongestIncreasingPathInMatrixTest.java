package com.github.algo.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestIncreasingPathInMatrixTest {

    @Test
    void longestIncreasingPath() {
        LongestIncreasingPathInMatrix longestIncreasingPath = new LongestIncreasingPathInMatrix();
        int[][] matrix = new int[][] {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        int i = longestIncreasingPath.longestIncreasingPath(matrix);
        assertEquals(4, i);
    }
}