package com.github.algo.dp;

import java.util.Arrays;
import java.util.LinkedList;

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = -1;
                }
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        if (obstacleGrid[m - 1][n - 1] != 0) {
            obstacleGrid[m - 1][n - 1] = 1;
        }
        Arrays.stream(obstacleGrid).map(Arrays::toString).forEach(System.out::println);
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 0 || i == m - 1 && j == n - 1) {
                    continue;
                }
                int lower = i + 1 < m ? obstacleGrid[i + 1][j] : 0;
                int right = j + 1 < n ? obstacleGrid[i][j + 1] : 0;
                obstacleGrid[i][j] = lower + right;
            }
        }
        Arrays.stream(obstacleGrid).map(Arrays::toString).forEach(System.out::println);
        return obstacleGrid[0][0];
    }

}
