package com.github.algo.mathgeometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxPointsOnALineTest {

    @Test
    void maxPoints() {
        int[][] points = {{1,1},{2,2},{3,3}};
        MaxPointsOnALine maxPointsOnALine = new MaxPointsOnALine();
        int abcd = maxPointsOnALine.maxPoints(points);
        System.out.println(abcd);
    }
}