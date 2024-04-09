package com.github.algo.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInStream {

    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;

    public KthLargestElementInStream(int k, int[] nums) {
        this.k = k;
        pq.addAll(Arrays.stream(nums).boxed().toList());
        while (pq.size() > k) {
            pq.remove();
        }
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > k) {
            pq.remove();
        }
        return pq.peek();
    }
}
