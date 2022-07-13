package com.github.algo.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueBinarySearchTreesTest {

    @Test
    void numTrees() {
        UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
        int i = uniqueBinarySearchTrees.numTrees(4);
        System.out.println(i);
    }
}