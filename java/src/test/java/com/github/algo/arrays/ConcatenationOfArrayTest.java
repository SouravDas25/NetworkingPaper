package com.github.algo.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ConcatenationOfArrayTest {

    @Test
    void getConcatenation() {
        ConcatenationOfArray concatenationOfArray = new ConcatenationOfArray();

        int[] concatenation = concatenationOfArray.getConcatenation(new int[]{1, 2, 1});

        System.out.println(Arrays.toString(concatenation));


        concatenation = concatenationOfArray.getConcatenation(new int[]{1, 3, 2, 1});

        System.out.println(Arrays.toString(concatenation));
    }
}