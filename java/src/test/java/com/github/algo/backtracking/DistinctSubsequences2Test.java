package com.github.algo.backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistinctSubsequences2Test {

    @Test
    void distinctSubseqII() {
        DistinctSubsequences2 distinctSubsequences2 = new DistinctSubsequences2();
        int abc = distinctSubsequences2.distinctSubseqII("aba");
        System.out.println(abc);
    }
}