package com.github.algo.graph;

import org.javatuples.Pair;

import java.util.HashSet;
import java.util.Set;

public class SurroundedRegions {

    int[][] movements = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private boolean isReachingBorder(int i, int j, char[][] board, Set<Pair<Integer, Integer>> visited, Set<Pair<Integer, Integer>> globalVisited) {
        visited.add(Pair.with(i, j));
        globalVisited.add(Pair.with(i, j));
        for (int[] move : movements) {
            int di = i + move[0], dj = j + move[1];
            if (di < board.length && di >= 0 && dj < board[di].length && dj >= 0) {
                if (board[di][dj] == 'O' && !visited.contains(Pair.with(di, dj)) && isReachingBorder(di, dj, board, visited, globalVisited)) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public void solve(char[][] board) {
        Set<Pair<Integer, Integer>> globalVisited = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O' && !globalVisited.contains(Pair.with(i, j))) {
                    Set<Pair<Integer, Integer>> visited = new HashSet<>();
                    boolean isReaching = isReachingBorder(i, j, board, visited, globalVisited);
                    if (!isReaching) {
                        for (Pair<Integer, Integer> point : visited) {
                            board[point.getValue0()][point.getValue1()] = 'X';
                        }
                    }
                }
            }
        }
    }

}
