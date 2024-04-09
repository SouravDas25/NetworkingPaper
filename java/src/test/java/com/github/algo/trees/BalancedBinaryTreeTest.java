package com.github.algo.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalancedBinaryTreeTest {

    @Test
    void isBalanced() {
        BinaryTree<Integer> tree = BinaryTree.generateTree(3,9,20,null,null,15,7);
        System.out.println(tree);
        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        boolean balanced = balancedBinaryTree.isBalanced(tree.root);
        assertTrue(balanced);
    }

    @Test
    void isBalanced1() {
        BinaryTree<Integer> tree = BinaryTree.generateTree(1, 2, 2, 3, 3, null, null, 4, 4);
        System.out.println(tree);
        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        boolean balanced = balancedBinaryTree.isBalanced(tree.root);
        assertFalse(balanced);
    }

}