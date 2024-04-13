package com.github.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MajorityElementTest {

    @Test
    void majorityElement() {
        MajorityElement majorityElement = new MajorityElement();
        int i = majorityElement.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        assertEquals(2, i);
    }

    @Test
    void majorityElement1() {
        MajorityElement majorityElement = new MajorityElement();
        int i = majorityElement.majorityElement(new int[]{3,3,4});
        assertEquals(3, i);
    }
}