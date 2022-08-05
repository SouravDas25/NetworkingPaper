package com.github.algo.backtracking;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Combinations {

    private int[] nums = new int[0];

    private void dfs(int k, int start, Deque<Integer> current, List<List<Integer>> output) {
        if (k <= 0) {
            output.add(List.copyOf(current));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            current.addLast(nums[i]);
            dfs(k - 1, i + 1, current, output);
            current.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> output = new LinkedList<>();
        dfs(k, 0, new LinkedList<>(), output);
        return output;
    }
}
