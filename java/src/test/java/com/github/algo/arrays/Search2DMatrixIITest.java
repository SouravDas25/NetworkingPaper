package com.github.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Search2DMatrixIITest {

    @Test
    void searchMatrix() {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        Search2DMatrixII search2DMatrixII = new Search2DMatrixII();
        boolean b = search2DMatrixII.searchMatrix(matrix, 5);
        System.out.println(b);
    }
}