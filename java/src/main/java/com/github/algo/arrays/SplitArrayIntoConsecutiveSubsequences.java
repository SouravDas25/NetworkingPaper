package com.github.algo.arrays;

import java.util.LinkedList;
import java.util.List;

public class SplitArrayIntoConsecutiveSubsequences {

    public boolean isPossible(int[] nums) {
        List<List<Integer>> output = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            boolean placed = false;
            for (List<Integer> sublist : output) {
                if (!sublist.isEmpty() && sublist.get(sublist.size() - 1) + 1 == nums[i]) {
                    placed = true;
                    sublist.add(nums[i]);
                    break;
                }
            }
            if (!placed) {
                List<Integer> integers = new LinkedList<>();
                integers.add(nums[i]);
                output.add(0, integers);
            }
        }
//        output.stream().map(List::toString).forEach(System.out::println);
        for (int i = 0; i < output.size(); i++) {
            if(output.get(i).size() < 3) {
                return false;
            }
        }
        return true;
    }
}
