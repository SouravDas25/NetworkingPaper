package com.github.algo.sorting;

public class BubbleSort {

    public <T extends Comparable<T>> void sort(T[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j].compareTo(nums[j + 1]) > 0) {
                    T tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }
}
