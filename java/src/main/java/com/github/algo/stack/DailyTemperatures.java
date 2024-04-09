package com.github.algo.stack;

import com.github.algo.util.Pair;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Pair<Integer, Integer>> stack = new LinkedList<>();
        int[] output = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int ct = temperatures[i];
            while (!stack.isEmpty() && stack.peek().getValue0() <= ct) {
                stack.pop();
            }
            output[i] = stack.isEmpty() ? 0 : stack.peek().getValue1() - i ;
            stack.push(Pair.with(ct, i));
        }
        return output;
    }
}
