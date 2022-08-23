package com.github.algo.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromeConcatenatingTwoLetterWordsTest {

    @Test
    void longestPalindrome() {
        LongestPalindromeConcatenatingTwoLetterWords longestPalindromeConcatenatingTwoLetterWords = new LongestPalindromeConcatenatingTwoLetterWords();
        int i = longestPalindromeConcatenatingTwoLetterWords.longestPalindrome(new String[]{"cc","ll","xx"});
        System.out.println(i);
    }
}