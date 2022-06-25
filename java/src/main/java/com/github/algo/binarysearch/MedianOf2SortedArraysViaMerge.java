package com.github.algo.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class MedianOf2SortedArraysViaMerge {

    private List<Integer> merge(int[] nums1, int[] nums2) {
        List<Integer> nums = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length || j < nums2.length) {
            int n;
            if (i >= nums1.length) {
                n = nums2[j];
                j++;
            } else if (j >= nums2.length) {
                n = nums1[i];
                i++;
            } else {
                if (nums1[i] <= nums2[j]) {
                    n = nums1[i];
                    i++;
                } else {
                    n = nums2[j];
                    j++;
                }
            }
            nums.add(n);
        }
        return nums;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> nums = merge(nums1, nums2);
        int mid = nums.size() / 2;
        if (nums.size() % 2 == 0) {
            return (nums.get(mid) + nums.get(mid - 1)) / 2.0;
        } else {
            return nums.get(mid);
        }
    }

}
