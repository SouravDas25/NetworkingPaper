package com.github.algo.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZigZagConversionTest {

    @Test
    void convert() {
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        String ab = zigZagConversion.convert("PAYPALISHIRING", 3);
        System.out.println(ab);
    }

}