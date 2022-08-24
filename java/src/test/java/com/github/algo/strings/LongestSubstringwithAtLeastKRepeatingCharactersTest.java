package com.github.algo.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringwithAtLeastKRepeatingCharactersTest {

    @Test
    void longestSubstring() {
        LongestSubstringwithAtLeastKRepeatingCharacters longestSubstringwithAtLeastKRepeatingCharacters = new LongestSubstringwithAtLeastKRepeatingCharacters();
        int aaabbbcc = longestSubstringwithAtLeastKRepeatingCharacters.longestSubstring("a", 1);
        System.out.println(aaabbbcc);
    }
}