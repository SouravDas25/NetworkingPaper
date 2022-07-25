package com.github.algo.dp;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class UniquePathsIITest {

    @Test
    void uniquePathsWithObstacles() {
        int[][] grid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        UniquePathsII uniquePathsII = new UniquePathsII();
        int i = uniquePathsII.uniquePathsWithObstacles(grid);
        System.out.println(i);
    }
}