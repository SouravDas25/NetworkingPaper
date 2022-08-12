package com.github.algo.arrays;

import java.util.Arrays;

public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        int ni = Integer.MAX_VALUE, nj = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= ni) {
                ni = num;
            } else if (num <= nj) {
                nj = num;
            } else {
                return true;
            }
        }
        return false;
    }

}
