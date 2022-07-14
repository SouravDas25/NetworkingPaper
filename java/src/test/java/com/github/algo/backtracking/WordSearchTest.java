package com.github.algo.backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordSearchTest {

    @Test
    void exist() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        WordSearch wordSearch = new WordSearch();
        boolean abcced = wordSearch.exist(board, "ABCCEDFD");
        assert abcced == false;

    }
}