package com.github.algo.sorting;

import java.util.Comparator;
import java.util.PriorityQueue;

public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int n : nums) {
            maxHeap.add(n);
        }
        for (int i = 1; i < nums.length; i+=2) {
            nums[i] = maxHeap.poll();
        }
        for (int i = 0; i < nums.length; i+=2) {
            nums[i] = maxHeap.poll();
        }
    }
}
