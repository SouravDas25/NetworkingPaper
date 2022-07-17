package com.github.algo.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinCostToConnectAllPointsTest {

    @Test
    void minCostConnectPoints() {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        MinCostToConnectAllPoints minCostToConnectAllPoints = new MinCostToConnectAllPoints();
        int i = minCostToConnectAllPoints.minCostConnectPoints(points);
        System.out.println(i);
    }
}