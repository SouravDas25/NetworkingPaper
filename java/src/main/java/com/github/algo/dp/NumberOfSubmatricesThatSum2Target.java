package com.github.algo.dp;

public class NumberOfSubmatricesThatSum2Target {

    private int dfs(int i, int j, int rc, int cc, int[][] matrix, int target) {
        if (i + rc > matrix.length || j + cc > matrix[i].length) {
            return 0;
        }
        int count = 0;
        int s = 0;
        for (int k = i; k < i + rc; k++) {
            for (int l = j; l < j + cc; l++) {
                s += matrix[k][l];
            }
        }
        if (s == target) {
            count++;
        }
        count += dfs(i, j, rc + 1, cc, matrix, target);
        count += dfs(i, j, rc, cc + 1, matrix, target);
        count += dfs(i, j, rc + 1, cc + 1, matrix, target);
        return count;
    }

    public int numMatrixSumTarget(int[][] matrix, int target) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                count += dfs(i, j, 1, 1, matrix, target);
            }
        }
        return count;
    }

}
