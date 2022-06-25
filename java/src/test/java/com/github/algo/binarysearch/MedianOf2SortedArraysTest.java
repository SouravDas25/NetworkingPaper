package com.github.algo.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianOf2SortedArraysTest {

    @Test
    void findMedianSortedArrays() {
        int[] nums1 = new int[]{}, nums2 = new int[]{2};
        MedianOf2SortedArrays medianOf2SortedArrays = new MedianOf2SortedArrays();
        double median = medianOf2SortedArrays.findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
    }
}