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
        String s = arrayConverter.convertToJavaArray("[[25,27],[36,187],[140,186],[378,6],[492,202],[517,89],[579,234],[673,86],[808,53],[954,49]]");
        System.out.println(s);
    }
}