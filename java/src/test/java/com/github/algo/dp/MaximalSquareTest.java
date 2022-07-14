package com.github.algo.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximalSquareTest {

    @Test
    void maximalSquare() {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        MaximalSquare maximalSquare = new MaximalSquare();
        int i = maximalSquare.maximalSquare(matrix);
        System.out.println(i);
    }
}