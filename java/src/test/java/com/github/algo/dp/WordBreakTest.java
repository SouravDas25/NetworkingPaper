package com.github.algo.dp;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordBreakTest {

    @Test
    void wordBreak() {
        WordBreak wb = new WordBreak();
        boolean b = wb.wordBreak("leetcode", List.of("leet", "code"));
        assertTrue(b);
    }

    @Test
    void wordBreak1() {
        WordBreak wb = new WordBreak();
        boolean b = wb.wordBreak("aaaaaaa", List.of("aaaa", "aaa"));
        assertTrue(b);
    }
}