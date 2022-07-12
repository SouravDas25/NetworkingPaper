package com.github.algo.trees;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LevelOrderTraversalTest {

    @Test
    void levelOrder() {
        BinaryTree<Integer> integerBinaryTree = BinaryTree.generateTree(1, 2, 3, null, null, 4, 5, 6, 7);
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        List<List<Integer>> lists = levelOrderTraversal.levelOrder(integerBinaryTree.root);
        System.out.println(integerBinaryTree);
        System.out.println(lists);
    }

    @Test
    void levelOrderBottom() {
        BinaryTree<Integer> integerBinaryTree = BinaryTree.generateTree(1, 2, 3, null, null, 4, 5, 6, 7);
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        List<List<Integer>> lists = levelOrderTraversal.levelOrderBottom(integerBinaryTree.root);
        System.out.println(integerBinaryTree);
        System.out.println(lists);
    }
}