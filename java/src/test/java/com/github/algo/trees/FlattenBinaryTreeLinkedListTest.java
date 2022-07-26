package com.github.algo.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlattenBinaryTreeLinkedListTest {

    @Test
    void flatten() {
        BinaryTree<Integer> integerBinaryTree = BinaryTree.generateTree(1, 2, 5, 3, 4, null, 6);
        FlattenBinaryTreeLinkedList flattenBinaryTreeLinkedList = new FlattenBinaryTreeLinkedList();
        flattenBinaryTreeLinkedList.flatten(integerBinaryTree.root);
        System.out.println(integerBinaryTree);
    }
}