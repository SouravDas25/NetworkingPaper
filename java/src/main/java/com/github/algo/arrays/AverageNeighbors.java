package com.github.algo.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class AverageNeighbors {

    public int[] rearrangeArray(int[] nums) {
        Integer[] integers = Arrays.stream(nums).sorted().boxed().toArray(Integer[]::new);
        int j = 1;
        for (int i = 0; i < integers.length; i++) {
            nums[j] = integers[i];
            j += 2;
            if (j >= nums.length) {
                j = 0;
            }
        }
        return nums;
    }

}
