package com.github.algo.dp;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximalSquare {

    private boolean isExtendable(char[][] matrix, int ix, int jx, int current) {
        for (int i = ix; i < ix + current + 1; i++) {
            int j = jx + current;
            if (i >= matrix.length || j >= matrix[i].length || matrix[i][j] != '1') {
                return false;
            }
        }
        for (int j = jx; j < jx + current; j++) {
            int i = ix + current;
            if (i >= matrix.length || j >= matrix[i].length || matrix[i][j] != '1') {
                return false;
            }
        }
        return true;
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length < 0) {
            return 0;
        }
        int maxSide = 0;

        Queue<Triplet<Integer, Integer, Integer>> points = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    points.add(Triplet.with(i, j, 1));
                    maxSide = 1;
                }
            }
        }

        while (!points.isEmpty()) {
            Triplet<Integer, Integer, Integer> point = points.poll();
            if (isExtendable(matrix, point.getValue0(), point.getValue1(), point.getValue2())) {
                maxSide = Math.max(maxSide, point.getValue2() + 1);
                points.add(point.setAt2(point.getValue2() + 1));
            }
        }
        return maxSide * maxSide;
    }
}
