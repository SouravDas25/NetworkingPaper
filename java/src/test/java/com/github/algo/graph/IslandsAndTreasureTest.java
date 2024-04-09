package com.github.algo.graph;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class IslandsAndTreasureTest {

    @Test
    void islandsAndTreasure() {
        IslandsAndTreasure islandsAndTreasure = new IslandsAndTreasure();
        int[][] grid = new int[][]{
                {99, -1, 0, 99},
                {99, 99, 99, -1},
                {99, -1, 99, -1},
                {0, -1, 99, 99}
        };
        islandsAndTreasure.islandsAndTreasure(grid);


        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }

    }
}