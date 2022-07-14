package com.github.algo.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NQueensTest {

    @Test
    void solveNQueens() {
        NQueens nQueens = new NQueens();
        List<List<String>> lists = nQueens.solveNQueens(4);
        System.out.println(lists);
    }
}