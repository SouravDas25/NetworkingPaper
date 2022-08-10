package com.github.algo.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WiggleSortIITest {

    @Test
    void wiggleSort() {
        WiggleSortII wiggleSortII = new WiggleSortII();
        int[] nums = {1, 5, 1, 1, 6, 4};
        wiggleSortII.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}