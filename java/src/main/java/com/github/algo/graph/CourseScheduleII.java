package com.github.algo.graph;

import java.util.*;

public class CourseScheduleII {

    Map<Integer, List<Integer>> graph = new HashMap<>();
    Map<Integer, Boolean> cache = new HashMap<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new LinkedList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }
        boolean[] visited = new boolean[numCourses];
        List<Integer> output = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                boolean canComplete = dfs(i, visited, output);
                if (!canComplete) {
                    return new int[0];
                }
            }
        }
        return output.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dfs(int i, boolean[] visited, List<Integer> output) {
        if (cache.containsKey(i)) {
            return cache.get(i);
        }
        visited[i] = true;
        for (int neighbor : graph.get(i)) {
            if (visited[neighbor] || !dfs(neighbor, visited, output)) {
                return false;
            }
        }
        visited[i] = false;
        cache.put(i, true);
        output.add(i);
        return true;
    }
}
