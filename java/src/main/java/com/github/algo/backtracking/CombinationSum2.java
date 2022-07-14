package com.github.algo.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationSum2 {

    private List<List<Integer>> output = new LinkedList<>();
    private int[] candidates;
    private Set<String> containsCheck = new HashSet<>();

    private void dfs(int target, int startFrom, Deque<Integer> current) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            List<Integer> collect = current.stream().sorted().collect(Collectors.toList());
            String key = collect.toString();
            if (!containsCheck.contains(key)) {
                output.add(collect);
                containsCheck.add(key);
            }
        }
        for (int i = startFrom; i < candidates.length; i++) {
            if (i > startFrom && candidates[i] == candidates[i - 1]) {
                continue;
            }
            current.addLast(candidates[i]);
            dfs(target - candidates[i], i + 1, current);
            current.removeLast();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        Arrays.sort(candidates);
        output.clear();
        dfs(target, 0, new LinkedList<>());
        return output;
    }
}
