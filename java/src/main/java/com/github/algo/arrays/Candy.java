package com.github.algo.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.PriorityQueue;

public class Candy {

    public int candy(int[] ratings) {
        int[] nc = new int[ratings.length];
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>(
                (a, b) -> {
                    if (Objects.equals(a[0], b[0])) {
                        return Integer.compare(a[1], b[1]);
                    }
                    return Integer.compare(a[0], b[0]);
                });
        for (int i = 0; i < ratings.length; i++) {
            minHeap.offer(new Integer[]{ratings[i], i});
            nc[i] = 1;
        }

        while (!minHeap.isEmpty()) {
            Integer[] poll = minHeap.poll();
            int n = poll[0];
            int index = poll[1];
            int leftCount = Integer.MIN_VALUE, rightCount = Integer.MIN_VALUE;
            if (index - 1 >= 0 && n > ratings[index - 1]) {
                leftCount = nc[index - 1];
            }
            if (index + 1 < ratings.length && n > ratings[index + 1]) {
                rightCount = nc[index + 1];
            }
            nc[index] = Collections.max(Arrays.asList(leftCount, rightCount, 0)) + nc[index];
        }
        return Arrays.stream(nc).sum();
    }

}
