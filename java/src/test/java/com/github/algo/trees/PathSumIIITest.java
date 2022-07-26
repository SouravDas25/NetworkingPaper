package com.github.algo.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathSumIIITest {

    @Test
    void pathSum() {
        BinaryTree<Integer> integerBinaryTree = BinaryTree.generateTree(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1);
        PathSumIII pathSumIII = new PathSumIII();
        int i = pathSumIII.pathSum(integerBinaryTree.root, 8);
        System.out.println(i);
    }
}