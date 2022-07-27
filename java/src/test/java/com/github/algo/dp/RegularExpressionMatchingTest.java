package com.github.algo.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularExpressionMatchingTest {

    @Test
    void isMatch() {
        RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
        boolean ab = regularExpressionMatching.isMatch("abc", "a*bcd*f*g*");
        System.out.println(ab);
    }
}