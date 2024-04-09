package com.github.algo.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateBinarySearchTreeTest {

    @Test
    void isValidBST() {
        BinaryTree<Integer> tree = BinaryTree.generateTree(2, 1, 3);
        System.out.println(tree);
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        boolean validBST = validateBinarySearchTree.isValidBST(tree.root);
        assertTrue(validBST);
    }

    @Test
    void isValidBST1() {
        BinaryTree<Integer> tree = BinaryTree.generateTree(5,1,4,null,null,3,6);
        System.out.println(tree);
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        boolean validBST = validateBinarySearchTree.isValidBST(tree.root);
        assertFalse(validBST);
    }

    @Test
    void isValidBST2() {
        BinaryTree<Integer> tree = BinaryTree.generateTree(5,4,6,null,null,3,7);
        System.out.println(tree);
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        boolean validBST = validateBinarySearchTree.isValidBST(tree.root);
        assertFalse(validBST);
    }

}