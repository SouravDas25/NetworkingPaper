package com.github.algo.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElement {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) {
            frequencyMap.putIfAbsent(n, 0);
            frequencyMap.put(n, frequencyMap.get(n) + 1);
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> -Integer.compare(a[0], b[0]));
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            maxHeap.add(new int[]{entry.getValue(), entry.getKey()});
        }
        int[] output = new int[k];
        for (int i = 0; i < k; i++) {
            output[i] = maxHeap.poll()[1];
        }
        return output;
    }
}
