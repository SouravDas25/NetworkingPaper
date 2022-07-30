package com.github.algo.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WildcardMatchingTest {

    @Test
    void isMatch() {
        WildcardMatching wildcardMatching = new WildcardMatching();
        boolean abc = wildcardMatching.isMatch("", "");
        System.out.println(abc);
    }

}