package com.github.algo.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ProductOfArrayExceptSelfTest {

    @Test
    void productExceptSelf() {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        int[] ints = productOfArrayExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(ints));
    }
}