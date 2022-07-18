package com.github.algo.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecodeWaysTest {

    @Test
    void numDecodings() {
        DecodeWays decodeWays = new DecodeWays();
        int i = decodeWays.numDecodings("226");
        System.out.println(i);
    }
}