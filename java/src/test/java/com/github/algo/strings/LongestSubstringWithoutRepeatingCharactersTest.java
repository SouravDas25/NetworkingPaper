package com.github.algo.strings;

import com.github.algo.slidingwindow.LongestSubstringWithoutRepeatingCharacters;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    void lengthOfLongestSubstring() {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        int i = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb");
        assertEquals(3, i);
    }
}