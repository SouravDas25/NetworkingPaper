package com.github.algo.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreesWithFactorsTest {

    @Test
    void numFactoredBinaryTrees() {
        BinaryTreesWithFactors binaryTreesWithFactors = new BinaryTreesWithFactors();
        int i = binaryTreesWithFactors.numFactoredBinaryTrees(new int[]{2, 3, 4, 6, 12, 18});
        System.out.println(i);
    }
}