package com.github.algo.slidingwindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestRepeatingCharacterReplacementTest {

    @Test
    void characterReplacement() {
        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
        int i = longestRepeatingCharacterReplacement.characterReplacement("ABAB", 2);
        assertEquals(4, i);
    }
}