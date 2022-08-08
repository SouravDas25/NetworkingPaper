package com.github.algo.mathgeometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerfectSquaresTest {

    @Test
    void numSquares() {
        PerfectSquares perfectSquares = new PerfectSquares();
        int i = perfectSquares.numSquares(12);
        System.out.println(i);
    }
}