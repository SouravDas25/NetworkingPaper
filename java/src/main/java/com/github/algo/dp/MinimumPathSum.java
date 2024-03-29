package com.github.algo.dp;

public class MinimumPathSum {

    private int getValue(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length) {
            return Integer.MAX_VALUE;
        }
        if (j < 0 || j >= grid[i].length) {
            return Integer.MAX_VALUE;
        }
        return grid[i][j];
    }

    public int minPathSum(int[][] grid) {
        if(grid.length <= 0 || grid[0].length <= 0) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) continue;
                grid[i][j] = Math.min(getValue(grid, i - 1, j), getValue(grid, i, j - 1)) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[grid.length - 1].length - 1];
    }
}
