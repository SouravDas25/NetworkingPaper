package com.github.algo.backtracking;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

    private List<List<Integer>> output = new LinkedList<>();
    private int[] candidates;

    private void dfs(int target, int startFrom, Deque<Integer> current) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            output.add(List.copyOf(current));
        }
        for (int i = startFrom; i < candidates.length; i++) {
            current.addLast(candidates[i]);
            dfs(target - candidates[i], i, current);
            current.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        output.clear();
        dfs(target, 0, new LinkedList<>());
        return output;
    }




}
