package com.github.algo.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ArrayConverterTest {

    @Test
    void convertToJavaArray() {
        ArrayConverter arrayConverter = new ArrayConverter();
        String s = arrayConverter.convertToJavaArray("[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]");
        System.out.println(s);
    }
}