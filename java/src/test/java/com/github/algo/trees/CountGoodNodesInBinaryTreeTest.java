package com.github.algo.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountGoodNodesInBinaryTreeTest {

    @Test
    void goodNodes() {
        BinaryTree<Integer> tree = BinaryTree.generateTree(3, 1, 4, 3, null, 1, 5);
        CountGoodNodesInBinaryTree countGoodNodesInBinaryTree = new CountGoodNodesInBinaryTree();
        int i = countGoodNodesInBinaryTree.goodNodes(tree.root);
        assertEquals(4, i);
    }

    @Test
    void goodNodes1() {
        BinaryTree<Integer> tree = BinaryTree.generateTree(-1, 5, -2, 4, 4, 2, -2, null, null, -4, null,
                -2, 3, null, -2, 0, null, -1, null, -3, null, -4, -3, 3, null, null, null, null, null, null,
                null, 3, -3);
        System.out.println(tree);
        CountGoodNodesInBinaryTree countGoodNodesInBinaryTree = new CountGoodNodesInBinaryTree();
        int i = countGoodNodesInBinaryTree.goodNodes(tree.root);
        assertEquals(5, i);
    }
}