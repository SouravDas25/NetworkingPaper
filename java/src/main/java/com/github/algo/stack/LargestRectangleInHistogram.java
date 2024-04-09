package com.github.algo.stack;

import com.github.algo.util.Pair;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        Deque<Pair<Integer, Integer>> stack = new LinkedList<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            int idx = i;
            while (!stack.isEmpty() && stack.peek().getValue0() > h) {
                Pair<Integer, Integer> pop = stack.pop();
                maxArea = Math.max(maxArea, pop.getValue0() * (i - pop.getValue1()));
                idx = pop.getValue1();
            }
            stack.push(Pair.with(h, idx));
        }
        while (!stack.isEmpty()) {
            Pair<Integer, Integer> pop = stack.pop();
            maxArea = Math.max(maxArea, pop.getValue0() * (heights.length - pop.getValue1()));
        }
        return maxArea;
    }

}
