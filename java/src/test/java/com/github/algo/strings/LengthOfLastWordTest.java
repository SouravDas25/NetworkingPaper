package com.github.algo.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthOfLastWordTest {

    @Test
    void lengthOfLastWord() {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        int helloWorld = lengthOfLastWord.lengthOfLastWord("hello world");
        assertEquals(helloWorld, 5);

        helloWorld = lengthOfLastWord.lengthOfLastWord("a");
        assertEquals(helloWorld, 1);
    }
}