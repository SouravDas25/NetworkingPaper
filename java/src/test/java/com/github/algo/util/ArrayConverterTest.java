package com.github.algo.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ArrayConverterTest {

    @Test
    void convertToJavaArray() {
        ArrayConverter arrayConverter = new ArrayConverter();
        String s = arrayConverter.convertToJavaArray("[[0,1,0],[1,1,1],[0,1,0]]");
        System.out.println(s);
    }
}