package com.github.algo.backtracking;

import org.assertj.core.util.Lists;

import java.util.*;

public class Subsets {

    private void dfs(int i, int[] nums, List<List<Integer>> output, Deque<Integer> current) {
        for (int j = i; j < nums.length; j++) {
            current.addLast(nums[j]);
            dfs(j + 1, nums, output, current);
            current.removeLast();
        }
        output.add(List.copyOf(current));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new LinkedList<>();
        Deque<Integer> current = new LinkedList<>();
        dfs(0, nums, subsets, current);
        return subsets;
    }
}
