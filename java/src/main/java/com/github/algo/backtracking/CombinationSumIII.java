package com.github.algo.backtracking;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {

    private int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    private void dfs(int target, int k, int startFrom, Deque<Integer> current, List<List<Integer>> output) {
        if (target == 0 && k == 0) {
            output.add(List.copyOf(current));
        }
        if (k < 0) {
            return;
        }
        for (int i = startFrom; i < nums.length; i++) {
            if (target - nums[i] < 0) break;
            current.addLast(nums[i]);
            dfs(target - nums[i], k - 1, i + 1, current, output);
            current.removeLast();
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> output = new LinkedList<>();
        dfs(n, k, 0, new LinkedList<>(), output);
        return output;
    }

}
