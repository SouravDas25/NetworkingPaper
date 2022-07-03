package com.github.algo.arrays;

import java.util.HashSet;
import java.util.Set;

public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        if (nums.length == 2) {
            return nums[0] == nums[1] ? 1 : 2;
        }

        int count = 1;
        Boolean isUpHill = null;
        for (int i = 1; i < nums.length; i++) {
            int difference = nums[i] - nums[i - 1];
            if (isUpHill == null) {
                if (nums[i - 1] != nums[i]) {
                    isUpHill = nums[i - 1] < nums[i];
                    count++;
                }
                continue;
            }
            if (isUpHill) {
                if (difference < 0) {
                    isUpHill = !isUpHill;
                    count++;
                }
            } else {
                if (difference > 0) {
                    isUpHill = !isUpHill;
                    count++;
                }
            }
        }
        System.out.println(count);
        return count;
    }

}
