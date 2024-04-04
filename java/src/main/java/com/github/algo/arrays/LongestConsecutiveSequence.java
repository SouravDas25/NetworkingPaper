package com.github.algo.arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int longest = 0;
        for (Integer n : numSet) {
            if (!numSet.contains(n - 1)) {
                int p = n;
                int length = 1;
                while (numSet.contains(p + 1)) {
                    p++;
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

}
