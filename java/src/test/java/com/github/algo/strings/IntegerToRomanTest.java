package com.github.algo.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerToRomanTest {

    @Test
    void intToRoman() {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        String s = integerToRoman.intToRoman(34);
        System.out.println(s);
    }
}