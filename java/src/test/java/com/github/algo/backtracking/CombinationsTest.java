package com.github.algo.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinationsTest {

    @Test
    void combine() {
        Combinations combinations = new Combinations();
        List<List<Integer>> combine = combinations.combine(4, 2);
        System.out.println(combine);
    }
}