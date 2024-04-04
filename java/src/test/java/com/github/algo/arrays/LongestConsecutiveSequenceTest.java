package com.github.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestConsecutiveSequenceTest {

    @Test
    void longestConsecutive() {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        int i = longestConsecutiveSequence.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        System.out.println(i);
    }
}