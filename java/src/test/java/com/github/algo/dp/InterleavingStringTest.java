package com.github.algo.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterleavingStringTest {

    @Test
    void isInterleave() {
        InterleavingString interleavingString = new InterleavingString();
        boolean interleave = interleavingString.isInterleave("aabcc", "dbbca", "aadbbcbcac");
        assertTrue(interleave);
    }

    @Test
    void isInterleave1() {
        InterleavingString interleavingString = new InterleavingString();
        boolean interleave = interleavingString.isInterleave("aa", "ab", "aaab");
        assertTrue(interleave);
    }
}