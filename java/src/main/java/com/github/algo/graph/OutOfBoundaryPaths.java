package com.github.algo.graph;

import java.util.HashMap;
import java.util.Map;

public class OutOfBoundaryPaths {

    private int getOutsideCount(int i, int j, int m, int n) {
        int outsideCount = 0;
        if (i == 0) outsideCount++;
        if (i == m - 1) outsideCount++;
        if (j == 0) outsideCount++;
        if (j == n - 1) outsideCount++;
        return outsideCount;
    }

    private int[][] movements = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private Map<String, Long> cache = new HashMap<>();

    public Long dfs(int[][] board, int maxMove, int i, int j) {
        if (maxMove <= 0) {
            return 0L;
        }
        String key = String.format("%d%d%d", i, j, maxMove);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        long count = board[i][j];
        for (int[] move : movements) {
            int di = i + move[0], dj = j + move[1];
            if (di < board.length && di >= 0 && dj < board[i].length && dj >= 0) {
                count += dfs(board, maxMove - 1, di, dj);
            }
        }
        cache.put(key, count);
        return count;
    }

    public long findPaths(int m, int n, int maxMove, int startRow, int startCol) {
        int[][] board = new int[m][n];
        cache.clear();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = getOutsideCount(i, j, m, n);
            }
        }
        return dfs(board, maxMove, startRow, startCol);
    }

}
