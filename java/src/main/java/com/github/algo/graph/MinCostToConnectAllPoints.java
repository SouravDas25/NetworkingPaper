package com.github.algo.graph;

import com.github.algo.util.Pair;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinCostToConnectAllPoints {

    public int minCostConnectPoints(int[][] points) {
        int[][] matrix = new int[points.length][points.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
            }
        }
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparing(Pair::getValue0));
        minHeap.add(Pair.with(matrix[0][0], 0));
        int minCost = 0;
        Set<Integer> visited = new HashSet<>();
        while (visited.size() < points.length) {
            Pair<Integer, Integer> poll = minHeap.poll();
            if (visited.contains(poll.getValue1())) continue;
            visited.add(poll.getValue1());
            minCost += poll.getValue0();
            for (int i = 0; i < matrix[poll.getValue1()].length; i++) {
                if (!visited.contains(i)) {
                    minHeap.add(Pair.with(matrix[poll.getValue1()][i], i));
                }
            }
        }
        return minCost;
    }
}
