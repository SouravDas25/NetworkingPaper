package com.github.algo.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubsetsIITest {

    @Test
    void subsetsWithDup() {
        SubsetsII ss = new SubsetsII();
        List<List<Integer>> lists = ss.subsetsWithDup(new int[]{1, 2, 2});
        System.out.println(lists);
    }
}