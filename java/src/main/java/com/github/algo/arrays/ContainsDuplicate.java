package com.github.algo.arrays;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) {
            if (numSet.contains(n)) {
                return true;
            }
            numSet.add(n);
        }
        return false;
    }
}
