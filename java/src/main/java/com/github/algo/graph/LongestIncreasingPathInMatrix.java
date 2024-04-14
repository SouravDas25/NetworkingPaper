package com.github.algo.graph;

import java.util.Arrays;

public class LongestIncreasingPathInMatrix {

    int[][] movement = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][] dp;
    int[][] matrix;

    int dfs(int i, int j) {
        if (dp[i][j] != 0) return dp[i][j];
        int max = 1;
        for (int[] move : movement) {
            int di = i + move[0];
            int dj = j + move[1];
            if (di < matrix.length && di >= 0 && dj < matrix[0].length && dj >= 0) {
                if (matrix[di][dj] > matrix[i][j]) {
                    max = Math.max(max, dfs(di, dj) + 1);
                }
            }
        }
        dp[i][j] = max;
        return max;
    }

    public int longestIncreasingPath(int[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];
        this.matrix = matrix;
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dfs(i, j));
            }
        }
        Arrays.stream(dp).map(Arrays::toString).forEach(System.out::println);
        return max;
    }

}
