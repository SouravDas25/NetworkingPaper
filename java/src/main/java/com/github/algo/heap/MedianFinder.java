package com.github.algo.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    private double median = 0;

    public MedianFinder() {

    }

    public void addNum(int num) {
        int size = minHeap.size() + maxHeap.size();
        if (size <= 0) {
            median = num;
            maxHeap.add(num);
            return;
        }
        boolean isEven = size % 2 == 0;
        if (num == median) {
            if (isEven) {
                maxHeap.add(num);
                median = num;
            } else {
                maxHeap.add(num);
                minHeap.add(maxHeap.remove());
                median = num;
            }
        } else if (num < median) {
            if (isEven) {
                maxHeap.add(num);
                median = maxHeap.peek();
            } else {
                maxHeap.add(num);
                minHeap.add(maxHeap.remove());
                median = (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
        } else {
            if (isEven) {
                minHeap.add(num);
                maxHeap.add(minHeap.remove());
                median = maxHeap.peek();

            } else {
                minHeap.add(num);
                median = (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
        }
    }

    public double findMedian() {
        return median;
    }

}
