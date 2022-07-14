package com.github.algo.graph;

public class NumberOfIslands {

    int[][] movements = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private void dfs(int i, int j, char[][] grid) {
        grid[i][j] = '*';
        for (int[] move : movements) {
            int di = i + move[0], dj = j + move[1];
            if (di < grid.length && di >= 0 && dj < grid[di].length && dj >= 0) {
                if (grid[di][dj] == '1') {
                    dfs(di, dj, grid);
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }
}
