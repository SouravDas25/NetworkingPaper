package com.github.algo.strings;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {

    @Test
    void longestCommonPrefix() {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] strs = Arrays.array("flower", "flow", "flight");
        String s = longestCommonPrefix.longestCommonPrefix(strs);
        System.out.println(s);
    }
}