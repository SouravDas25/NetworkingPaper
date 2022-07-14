package com.github.algo.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfIslandsTest {

    @Test
    void numIslands() {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        NumberOfIslands numberOfIslands = new NumberOfIslands();
        int i = numberOfIslands.numIslands(grid);
        System.out.println(i);
    }
}