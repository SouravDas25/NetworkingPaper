package com.github.algo.linkedlist;

public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int fp = 0, sp = 0;
        do {
            sp = nums[sp];
            fp = nums[nums[fp]];
        } while (fp != sp);
        int sp2 = 0;
        while (sp2 != sp) {
            sp = nums[sp];
            sp2 = nums[sp2];
        }
        return sp;
    }

}
