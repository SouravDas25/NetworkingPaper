package com.github.algo.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {

    private <T extends Comparable<T>> T[] merge(T[] array1, T[] array2) {
        T[] array3 = Arrays.copyOf(array1, array1.length + array2.length);
        int count = 0;
        int i = 0, j = 0;
        while (i < array1.length || j < array2.length) {
            if (i >= array1.length) {
                array3[count++] = array2[j++];
            } else if (j >= array2.length) {
                array3[count++] = array1[i++];
            } else {
                if (array1[i].compareTo(array2[j]) <= 0) {
                    array3[count++] = array1[i++];
                } else {
                    array3[count++] = array2[j++];
                }
            }
        }
        return array3;
    }

    private <T extends Comparable<T>> T[] splitSort(T[] values, int left, int right) {
        if (right - left <= 0) {
            return Arrays.copyOfRange(values, left, left + 1);
        }
        int mid = left + (right - left) / 2;
        T[] lower = splitSort(values, left, mid);
        T[] higher = splitSort(values, mid + 1, right);
        return merge(lower, higher);
    }

    public <T extends Comparable<T>> void sort(T[] values) {
        T[] split = splitSort(values, 0, values.length - 1);
        for (int i = 0; i < values.length; i++) {
            values[i] = split[i];
        }
    }
}
