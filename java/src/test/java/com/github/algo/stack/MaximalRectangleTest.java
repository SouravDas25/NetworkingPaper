package com.github.algo.stack;

import com.github.algo.stack.MaximalRectangle;
import org.junit.jupiter.api.Test;

class MaximalRectangleTest {

    @Test
    void maximalRectangle() {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        int i = maximalRectangle.maximalRectangle(matrix);
        System.out.println(i);

    }
}