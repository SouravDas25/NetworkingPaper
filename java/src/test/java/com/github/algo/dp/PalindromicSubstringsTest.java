package com.github.algo.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromicSubstringsTest {

    @Test
    void countSubstrings() {
        PalindromicSubstrings ps = new PalindromicSubstrings();
        int i = ps.countSubstrings("aaa");
        assertEquals(6, i);
    }
}