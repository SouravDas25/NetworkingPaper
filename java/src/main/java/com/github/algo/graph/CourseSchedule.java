package com.github.algo.graph;

import java.util.*;

public class CourseSchedule {

    private boolean dfs(int courseNum, Map<Integer, List<Integer>> courses, Set<Integer> visited, Map<Integer, Boolean> cache) {
        if (visited.contains(courseNum)) {
            cache.put(courseNum, false);
            return false;
        }
        if (cache.containsKey(courseNum)) {
            return cache.get(courseNum);
        }
        visited.add(courseNum);
        for (Integer course : courses.get(courseNum)) {
            if (!dfs(course, courses, visited, cache)) {
                cache.put(courseNum, false);
                return false;
            }
        }
        visited.remove(courseNum);
        cache.put(courseNum, true);
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> course = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            course.put(i, new LinkedList<>());
        }
        for (int[] dependent : prerequisites) {
            course.get(dependent[0]).add(dependent[1]);
        }
        Map<Integer, Boolean> cache = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            Set<Integer> visited = new HashSet<>();
            boolean dfs = dfs(i, course, visited, cache);
            if (!dfs) return false;
        }
        return true;
    }
}
