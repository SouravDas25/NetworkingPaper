package com.github.algo.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            List<Integer> integers = Arrays.asList(nums[i], minProduct * nums[i], maxProduct * nums[i]);
            maxProduct = Collections.max(integers);
            minProduct = Collections.min(integers);
            max = Math.max(max, maxProduct);
        }
        return max;
    }

}
