package com.github.algo.graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PacificAtlanticWaterFlowTest {

    @Test
    void pacificAtlantic() {
        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        PacificAtlanticWaterFlow pacificAtlanticWaterFlow= new PacificAtlanticWaterFlow();
        List<List<Integer>> lists = pacificAtlanticWaterFlow.pacificAtlantic(heights);
        System.out.println(lists);
    }
}