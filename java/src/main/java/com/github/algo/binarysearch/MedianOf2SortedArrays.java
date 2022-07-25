package com.github.algo.binarysearch;

public class MedianOf2SortedArrays {

    private int properValues(int[] nums1, int index) {
        if (index < 0) {
            return Integer.MIN_VALUE;
        }
        if( index >= nums1.length) {
            return Integer.MAX_VALUE;
        }
        return nums1[index];
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] ymp = nums1;
            nums1 = nums2;
            nums2 = ymp;
        }
        int tl = nums1.length + nums2.length, l = 0, r = nums1.length;
        int half = (tl+1)/ 2;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int lu = properValues(nums1, mid -1 );
            int ru = properValues(nums1, mid );
            int mid2 = half - mid;
            int ld = properValues(nums2, mid2 - 1);
            int rd = properValues(nums2, mid2 );
            if (lu <= rd && ld <= ru) {
                if (tl % 2 == 0) {
                    return (Math.min(rd, ru) + Math.max(lu, ld)) / 2.0;
                } else {
                    return Math.max(lu, ld);
                }
            }
            if (ld > lu) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return 0;
    }

}
