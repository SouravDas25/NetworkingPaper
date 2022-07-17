package com.github.algo.graph;

import com.github.algo.util.Pair;

import java.util.*;

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] matrix = new int[n + 1][n + 1];
        Arrays.stream(matrix).forEach(a -> Arrays.fill(a, -1));
        Arrays.stream(times).forEach(edge -> matrix[edge[0]][edge[1]] = edge[2]);
//        Arrays.stream(matrix).map(Arrays::toString).forEach(System.out::println);

        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparing(Pair::getValue0));
        minHeap.add(Pair.with(0, k));
        Set<Integer> visited = new HashSet<>();
        int maxDelay = 0;
        while (visited.size() < n) {
            if (minHeap.isEmpty()) {
                return -1;
            }
            Pair<Integer, Integer> poll = minHeap.poll();
            visited.add(poll.getValue1());
            maxDelay = Math.max(maxDelay, poll.getValue0());
            for (int i = 0; i < matrix[poll.getValue1()].length; i++) {
                if (!visited.contains(i) && matrix[poll.getValue1()][i] != -1) {
                    int costToReach = poll.getValue0() + matrix[poll.getValue1()][i];
                    minHeap.add(Pair.with(costToReach, i));
                }
            }
        }
        return maxDelay;
    }
}
