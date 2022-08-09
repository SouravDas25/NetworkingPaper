package com.github.algo.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class CountSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> sortedList = new ArrayList<>(nums.length * 2);
        List<Integer> output = new ArrayList<>(4);
        int previousVal = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                output.add(previousVal);
                sortedList.add(previousVal, nums[i]);
            } else {
                int j = Collections.binarySearch(sortedList, nums[i]);
                while (j > 0 && Objects.equals(sortedList.get(j - 1), sortedList.get(j))) {
                    j--;
                }
                int val = j < 0 ? Math.max(Math.abs(j) - 1, 0) : j;
                output.add(val);
                sortedList.add(val, nums[i]);
                previousVal = val;
            }
            System.out.println(sortedList);
        }
        Collections.reverse(output);
        return output;
    }

}
