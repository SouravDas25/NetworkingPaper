package com.github.algo.graph;

public class MaxAreaOfIsland {

    int[][] movements = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private int dfs(int i, int j, int[][] grid) {
        grid[i][j] = -1;
        int count = 1;
        for (int[] move : movements) {
            int di = i + move[0], dj = j + move[1];
            if (di < grid.length && di >= 0 && dj < grid[di].length && dj >= 0) {
                if (grid[di][dj] == 1) {
                    count += dfs(di, dj, grid);
                }
            }
        }
        return count;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(i, j, grid);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

}
