package com.github.algo.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianOf2SortedArraysViaMergeTest {

    @Test
    void findMedianSortedArrays() {
        int[] nums1 = new int[]{1,3}, nums2 = new int[]{2};
        MedianOf2SortedArraysViaMerge medianOf2SortedArraysViaMerge = new MedianOf2SortedArraysViaMerge();
        double median = medianOf2SortedArraysViaMerge.findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
    }
}