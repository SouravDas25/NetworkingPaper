package com.github.algo.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesfromSortedArrayTest {

    @Test
    void removeDuplicates() {
        RemoveDuplicatesfromSortedArray removeDuplicatesfromSortedArray = new RemoveDuplicatesfromSortedArray();
        int[] ints = {1, 2, 2, 3, 3, 4};
        int i = removeDuplicatesfromSortedArray.removeDuplicates(ints);
        System.out.println(Arrays.toString(ints) + i);
    }
}