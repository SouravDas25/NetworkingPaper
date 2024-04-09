package com.github.algo.backtracking;

import com.google.common.collect.Lists;
import org.assertj.core.util.Sets;

import java.util.*;

public class SubsetsII {

    HashSet<String> output = new HashSet<>();

    void dfs(int i, int[] nums, Deque<Integer> current) {
        for (int j = i; j < nums.length; j++) {
            current.addLast(nums[j]);
            dfs(j + 1, nums, current);
            current.removeLast();
        }
        List<Integer> integers = new ArrayList<>(current);
        integers.sort(Integer::compareTo);
        String value = String.join(",", integers.stream().map(String::valueOf).toList());
        output.add(value);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        output.clear();
        Deque<Integer> current = new LinkedList<>();
        dfs(0, nums, current);
        return output.stream()
                .map(str -> str.split(","))
                .map(Arrays::asList)
                .map(list -> list.stream().filter(val -> !val.isBlank()).map(Integer::valueOf).toList())
                .toList();
    }

}
