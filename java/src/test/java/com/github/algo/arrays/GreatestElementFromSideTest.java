package com.github.algo.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GreatestElementFromSideTest {

    @Test
    void replaceElements() {
        GreatestElementFromSide greatestElementFromSide = new GreatestElementFromSide();
        int[] ints = greatestElementFromSide.replaceElements(new int[]{17, 18, 5, 4, 6, 1});
        System.out.println(Arrays.toString(ints));
    }
}