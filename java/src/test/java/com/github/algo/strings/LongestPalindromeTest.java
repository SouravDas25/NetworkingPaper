package com.github.algo.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromeTest {

    @Test
    void longestPalindrome() {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        int abccccdddd = longestPalindrome.longestPalindrome("aaa");
        System.out.println(abccccdddd);
    }
}