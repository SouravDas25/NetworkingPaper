package com.github.algo.backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountAndSayTest {

    @Test
    void countAndSay() {
        CountAndSay countAndSay = new CountAndSay();
        String s = countAndSay.countAndSay(4);
        System.out.println(s);
    }
}