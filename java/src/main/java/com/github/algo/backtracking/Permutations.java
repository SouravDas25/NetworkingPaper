package com.github.algo.backtracking;

import java.util.*;

public class Permutations {

    private List<List<Integer>> output = new LinkedList<>();
    private int[] nums;

    private void swap(int i, int j) {
        int tm = nums[i];
        nums[i] = nums[j];
        nums[j] = tm;
    }


    public void dfs(int i, Deque<Integer> current ) {
        if (i >= nums.length) {
            output.add(List.copyOf(current));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            swap(i, j);
            current.addLast(nums[i]);
            dfs(i + 1, current);
            current.removeLast();
            swap(i, j);
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        Deque<Integer> current = new LinkedList<>();
        dfs(0, current);
        return output;
    }

}
