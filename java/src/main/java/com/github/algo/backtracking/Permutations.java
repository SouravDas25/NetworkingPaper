package com.github.algo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

    private List<List<Integer>> output = new LinkedList<>();
    private int[] nums;

    private void swap(int i, int j) {
        int tm = nums[i];
        nums[i] = nums[j];
        nums[j] = tm;
    }

    private void dfs(int i) {
        if (i == nums.length) {
            output.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }
        for (int j = i; j < nums.length; j++) {
            swap(i, j);
            dfs(i + 1);
            swap(i, j);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        output.clear();
        dfs(0);
        return output;
    }
}
