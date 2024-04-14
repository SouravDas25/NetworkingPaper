package com.github.algo.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularExpressionMatchingRecursionTest {

    @Test
    void isMatch() {
        RegularExpressionMatchingRecursion recursion = new RegularExpressionMatchingRecursion();
        boolean match = recursion.isMatch("abcd", "abcd");
        assertTrue(match);
    }

    @Test
    void isMatch1() {
        RegularExpressionMatchingRecursion recursion = new RegularExpressionMatchingRecursion();
        boolean match = recursion.isMatch("aa", "a*");
        assertTrue(match);
    }

    @Test
    void isMatch2() {
        RegularExpressionMatchingRecursion recursion = new RegularExpressionMatchingRecursion();
        boolean match = recursion.isMatch("aaa", ".a*");
        assertTrue(match);
    }

    @Test
    void isMatch3() {
        RegularExpressionMatchingRecursion recursion = new RegularExpressionMatchingRecursion();
        boolean match = recursion.isMatch("abcd", "abab");
        assertFalse(match);
    }

    @Test
    void isMatch4() {
        RegularExpressionMatchingRecursion recursion = new RegularExpressionMatchingRecursion();
        boolean match = recursion.isMatch("mississippi", "mis*is*ip*.");
        assertTrue(match);
    }

    @Test
    void isMatch5() {
        RegularExpressionMatchingRecursion recursion = new RegularExpressionMatchingRecursion();
        boolean match = recursion.isMatch("aa", "a");
        assertFalse(match);
    }
}