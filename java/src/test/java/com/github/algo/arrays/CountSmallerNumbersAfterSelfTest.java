package com.github.algo.arrays;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountSmallerNumbersAfterSelfTest {

    @Test
    void countSmaller() {
        CountSmallerNumbersAfterSelf countSmallerNumbersAfterSelf = new CountSmallerNumbersAfterSelf();
        List<Integer> integers = countSmallerNumbersAfterSelf.countSmaller(new int[]{2,2,2,1,2,2,2,2,2,2});
        System.out.println(integers);
    }
}