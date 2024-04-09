package com.github.algo.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvertBinaryTreeTest {

    @Test
    void invertTree() {
        BinaryTree<Integer> tree = BinaryTree.generateTree(4, 2, 7, 1, 3, 6, 9);
        System.out.println(tree);
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode treeNode = invertBinaryTree.invertTree(tree.root);
        System.out.println(tree);
    }
}