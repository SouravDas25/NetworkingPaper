package com.github.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntersectionTwoArraysIITest {

    @Test
    void intersect() {
        IntersectionTwoArraysII intersectionTwoArraysII = new IntersectionTwoArraysII();
        int[] intersect = intersectionTwoArraysII.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        System.out.println(intersect);
    }
}