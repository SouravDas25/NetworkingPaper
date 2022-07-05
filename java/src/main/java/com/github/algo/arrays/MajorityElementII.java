package com.github.algo.arrays;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        int ans1 = 0;
        int ans2 = 1;
        int count1 = 0;
        int count2 = 0;
        for (int num : nums) {
            if (num == ans1) {
                count1++;
            } else if (num == ans2) {
                count2++;
            } else if (count1 == 0) {
                ans1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                ans2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        for (final int num : nums) {
            if (num == ans1) {
                ++count1;
            } else if (num == ans2) {
                ++count2;
            }
        }
        List<Integer> result = new ArrayList<>();
        if (count1 > nums.length / 3) {
            result.add(ans1);
        }
        if (count2 > nums.length / 3) {
            result.add(ans2);
        }
        return result;
    }
}
