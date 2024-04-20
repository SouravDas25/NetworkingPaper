package com.github.algo.intervals;

import java.util.*;

public class MinimumIntervalToIncludeEachQuery {
    record Pair(int r, int end) {
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        Map<Integer, Deque<Integer>> map = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            map.putIfAbsent(queries[i], new LinkedList<>());
            map.get(queries[i]).add(i);
        }

        Arrays.sort(queries);

        int[] results = new int[queries.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::r));
        int i = 0;
        for (int j = 0; j < queries.length; j++) {
            int query = queries[j];
            while (i < intervals.length && intervals[i][0] <= query) {
                int r = intervals[i][1] - intervals[i][0] + 1;
                pq.add(new Pair(r, intervals[i][1]));
                i++;
            }
            pq.removeIf(mem -> mem.end < query);
            int index = map.get(query).removeFirst();
            if (pq.isEmpty()) {
                results[index] = -1;
            } else {
                results[index] = pq.peek().r;
            }
        }
        return results;
    }

}
