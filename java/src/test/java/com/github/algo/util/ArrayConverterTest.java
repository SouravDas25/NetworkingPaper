package com.github.algo.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ArrayConverterTest {

    @Test
    void convertToJavaArray() {

        ArrayConverter arrayConverter = new ArrayConverter();
        String s = arrayConverter.convertToJavaArray("[[1,1],[2,2],[3,3]]");
        System.out.println(s);
    }
}