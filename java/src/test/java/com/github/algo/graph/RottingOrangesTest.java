package com.github.algo.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RottingOrangesTest {

    @Test
    void orangesRotting() {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        RottingOranges rottingOranges = new RottingOranges();
        int minutes = rottingOranges.orangesRotting(grid);
        System.out.println(minutes);


    }
}