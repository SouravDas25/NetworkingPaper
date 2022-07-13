package com.github.algo.dp;

import org.javatuples.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class MaximalRectangle {

    private int maxAreaInHistogram(int[] heights) {
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int storeIndex = i;
            while (!stack.isEmpty() && stack.peek().getValue0() > heights[i]) {
                Pair<Integer, Integer> poped = stack.pop();
                int area = poped.getValue0() * Math.abs(i - poped.getValue1());
                maxArea = Math.max(area, maxArea);
                storeIndex = poped.getValue1();
            }
            stack.push(Pair.with(heights[i], storeIndex));
        }
        while (!stack.isEmpty()) {
            Pair<Integer, Integer> poped = stack.pop();
            int area = poped.getValue0() * Math.abs(heights.length - poped.getValue1());
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length <= 0) {
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        Arrays.fill(heights, 0);
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            int area = maxAreaInHistogram(heights);
            maxArea = Math.max(maxArea, area);
            System.out.println(Arrays.toString(heights) + " " + area);
        }
        return maxArea;
    }

}
