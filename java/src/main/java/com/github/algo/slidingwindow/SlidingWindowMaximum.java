package com.github.algo.slidingwindow;

import java.util.*;

public class SlidingWindowMaximum {

    public class MonotonicQueue {
        private Deque<Integer> deque = new ArrayDeque<>();

        // Push operation
        public void push(int num) {
            while (!deque.isEmpty() && num > deque.getLast()) {
                deque.removeLast();
            }
            deque.addLast(num);
        }

        // Pop operation
        public void pop(int num) {
            if (!deque.isEmpty() && num == deque.getFirst()) {
                deque.removeFirst();
            }
        }

        // Get the maximum element
        public int getMax() {
            return deque.getFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue sortedQueue = new MonotonicQueue();
        for (int i = 0; i < k; i++) {
            sortedQueue.push(nums[i]);
        }
        List<Integer> output = new LinkedList<>();
        output.add(sortedQueue.getMax());
        int j = 0;
        for (int i = k; i < nums.length; i++) {
            sortedQueue.pop(nums[j]);
            sortedQueue.push(nums[i]);
            Integer poll = sortedQueue.getMax();
            output.add(poll);
            j++;
        }
        return output.stream().mapToInt(Integer::intValue).toArray();
    }
}
