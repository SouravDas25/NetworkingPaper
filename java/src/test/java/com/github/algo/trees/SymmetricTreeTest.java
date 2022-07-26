package com.github.algo.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SymmetricTreeTest {

    @Test
    void isSymmetric() {
        SymmetricTree symmetricTree = new SymmetricTree();
        BinaryTree<Integer> integerBinaryTree = BinaryTree.generateTree(1,2,2,null,3,null,3);
        boolean symmetric = symmetricTree.isSymmetric(integerBinaryTree.root);
        System.out.println(symmetric);
    }
}