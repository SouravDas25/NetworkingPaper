package com.github.algo.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanToIntegerTest {

    @Test
    void romanToInt() {
        RomanToInteger romanToInteger = new RomanToInteger();
        int xxii = romanToInteger.romanToInt("MCMXCIV");
        System.out.println(xxii);
    }
}