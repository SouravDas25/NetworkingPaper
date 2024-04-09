package com.github.algo.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiameterOfBinaryTreeTest {

    @Test
    void diameterOfBinaryTree() {
        BinaryTree<Integer> tree = BinaryTree.generateTree(1, 2, 3, 4, 5);
        System.out.println(tree);
        DiameterOfBinaryTree diameter = new DiameterOfBinaryTree();
        int i = diameter.diameterOfBinaryTree(tree.root);
        assertEquals(3, i);
    }

    @Test
    void diameterOfBinaryTree1() {
        BinaryTree<Integer> tree = BinaryTree.generateTree(1,2);
        System.out.println(tree);
        DiameterOfBinaryTree diameter = new DiameterOfBinaryTree();
        int i = diameter.diameterOfBinaryTree(tree.root);
        assertEquals(1, i);
    }
}