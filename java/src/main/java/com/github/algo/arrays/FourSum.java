package com.github.algo.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class FourSum {

    boolean isOverflow(int left, int right) {
        return right > 0
                ? Integer.MAX_VALUE - right < left
                : Integer.MIN_VALUE - right > left;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Map<Integer, Integer> numCount = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numCount.put(nums[i], i);
        }
        Set<String> duplicates = new HashSet<>();
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int z;
                    try {
                        z = Math.addExact(nums[i], nums[j]);
                        z = Math.addExact(z, nums[k]);
                        z = Math.subtractExact(target, z);
                    } catch (ArithmeticException e) {
                        continue;
                    }
                    if (numCount.containsKey(z) && numCount.get(z) != i && numCount.get(z) != j && numCount.get(z) != k) {
                        Integer[] sorted = {nums[i], nums[j], nums[k], nums[numCount.get(z)]};
                        Arrays.sort(sorted);
                        String s = Arrays.toString(sorted);
                        if (!duplicates.contains(s)) {
                            duplicates.add(s);
                            output.add(Arrays.asList(sorted));
                        }
                    }
                }
            }
        }
        return output;

    }

}
