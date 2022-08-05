package com.github.algo.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinationSumIIITest {

    @Test
    void combinationSum3() {
        CombinationSumIII combinationSumIII = new CombinationSumIII();
        List<List<Integer>> lists = combinationSumIII.combinationSum3(3, 9);
        System.out.println(lists);
    }
}