package com.github.algo.binarysearch;

public class SearchInRotatedSortedArray {

    // write a binary search
    int binarySearch(int[] array, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[low] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[low]) {
                    return binarySearch(nums, low, mid, target);
                } else {
                    low = mid + 1;
                }
            } else {
                if (target <= nums[high] && target > nums[mid]) {
                    return binarySearch(nums, mid + 1, high, target);
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
