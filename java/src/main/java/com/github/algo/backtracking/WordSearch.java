package com.github.algo.backtracking;

import org.javatuples.Pair;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {

    int[][] movements = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private boolean dfs(int i, int j, int c, char[][] board, Set<Pair<Integer, Integer>> visited, String word) {
        if (c >= word.length()) {
            return true;
        }
        visited.add(Pair.with(i, j));
        for (int[] move : movements) {
            int di = i + move[0], dj = j + move[1];
            if (di >= 0 && di < board.length && dj >= 0 && dj < board[i].length && !visited.contains(Pair.with(di, dj))) {
                if (word.charAt(c) == board[di][dj] && dfs(di, dj, c + 1, board, visited, word)) {
                    return true;
                }
            }
        }
        visited.remove(Pair.with(i, j));
        return false;
    }

    public boolean exist(char[][] board, String word) {
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(i, j, 1, board, visited, word)) {
                    return true;
                }
            }
        }
        return false;
    }
}
