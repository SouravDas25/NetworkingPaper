package com.github.algo.slidingwindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumWindowSubstringTest {

    @Test
    void minWindow() {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        String string = minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC");
        assertEquals("BANC", string);
    }
}