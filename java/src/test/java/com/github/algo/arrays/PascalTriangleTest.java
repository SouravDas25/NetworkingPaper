package com.github.algo.arrays;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PascalTriangleTest {

    @Test
    void generate() {
        PascalTriangle pascalTriangle = new PascalTriangle();
        List<List<Integer>> generate = pascalTriangle.generate(5);
        System.out.println(generate);
    }
}