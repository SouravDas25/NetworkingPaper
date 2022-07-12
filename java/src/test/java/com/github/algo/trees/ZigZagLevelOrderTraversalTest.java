package com.github.algo.trees;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ZigZagLevelOrderTraversalTest {

    @Test
    void zigzagLevelOrder() {
        BinaryTree<Integer> integerBinaryTree = BinaryTree.generateTree(3,9,20,15,7,4,5);
        ZigZagLevelOrderTraversal levelOrderTraversal = new ZigZagLevelOrderTraversal();
        List<List<Integer>> lists = levelOrderTraversal.zigzagLevelOrder(integerBinaryTree.root);
        System.out.println(integerBinaryTree);
        System.out.println(lists);
    }
}