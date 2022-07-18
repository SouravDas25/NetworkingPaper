package com.github.algo.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecodeWaysTest {

    @Test
    void numDecodings() {
        DecodeWays decodeWays = new DecodeWays();
        long i = decodeWays.numDecodings("121212121212121212121212121212121121212121212121212121212121212121121212121212121212121212121212121121212121212121212121212121212121");
        System.out.println(i);
    }
}