package com.github.algo.sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    private <T extends Comparable<T>> int findPivot(T[] values, int left, int right) {
        int minIndex = left;
        for (int i = left; i <= right; i++) {
            if (values[minIndex].compareTo(values[i]) > 0) {
                minIndex = i;
            }
        }
        Random random = new Random();
        random.setSeed(minIndex);
        int length = right - left + 1;
        return left + (Math.abs(random.nextInt()) % length);
    }

    private <T extends Comparable<T>> void swap(T[] values, int i, int j) {
        T tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }

    private <T extends Comparable<T>> void sort(T[] values, int left, int right) {
        if (left >= right) {
            return;
        }
        int median = findPivot(values, left, right);
        System.out.printf("%s : %d -> %d, %d\n", Arrays.toString(values), median, left, right);
        int pivot = right;
        swap(values, median, pivot);
        int i = left;
        while (i < pivot) {
            if (values[pivot].compareTo(values[i]) < 0) {
                T tmp = values[pivot];
                values[pivot] = values[i];
                values[i] = values[pivot - 1];
                values[pivot - 1] = tmp;
                pivot--;
            } else {
                i++;
            }
        }
        sort(values, left, pivot - 1);
        sort(values, pivot + 1, right);
    }

    public <T extends Comparable<T>> void sort(T[] values) {
        sort(values, 0, values.length - 1);
    }
}
