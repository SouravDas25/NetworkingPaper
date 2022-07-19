package com.github.algo.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecodeWaysIITest {

    @Test
    void numDecodings() {
        DecodeWaysII decodeWaysII = new DecodeWaysII();
        int i = decodeWaysII.numDecodings("7*9*3*6*3*0*5*4*9*7*3*7*1*8*3*2*0*0*6*");
        System.out.println(i);
    }
}