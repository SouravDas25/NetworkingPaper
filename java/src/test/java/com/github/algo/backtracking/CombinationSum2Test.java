package com.github.algo.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinationSum2Test {

    @Test
    void combinationSum2() {
        CombinationSum2 combinationSum = new CombinationSum2();
        List<List<Integer>> lists = combinationSum.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(lists);
    }
}