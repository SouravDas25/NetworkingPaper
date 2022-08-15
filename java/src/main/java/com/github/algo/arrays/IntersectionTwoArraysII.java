package com.github.algo.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IntersectionTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] nums = nums1.length < nums2.length ? nums2 : nums1;
        int[] numsFM = nums1.length < nums2.length ? nums1 : nums2;
        Map<Integer, Long> countedMap = Arrays.stream(numsFM).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Integer> output = new LinkedList<>();
        for (int n : nums) {
            if (countedMap.containsKey(n)) {
                output.add(n);
                countedMap.put(n, countedMap.get(n) - 1);
                if (countedMap.get(n) < 1) {
                    countedMap.remove(n);
                }
            }
        }
        int[] out = new int[output.size()];
        for (int i = 0; i < output.size(); i++) {
            out[i] = output.get(i);
        }
        return out;
    }

}
