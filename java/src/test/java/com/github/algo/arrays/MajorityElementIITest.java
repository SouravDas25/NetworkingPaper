package com.github.algo.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class MajorityElementIITest {

    @Test
    void majorityElement() {
        int[] nums = {2, 2, 1, 3};
        MajorityElementII majorityElementII = new MajorityElementII();
        List<Integer> integers = majorityElementII.majorityElement(nums);
        System.out.println(integers);

    }
}