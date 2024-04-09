package com.github.algo.trees;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreeInOrderTraversalWithStackTest {

    @Test
    void inorderTraversal() {
        BinaryTree<Integer> tree = BinaryTree.generateTree(1, 2, 3, 4, 5, 6, 7);
        TreeInOrderTraversalWithStack inOrderTraversal = new TreeInOrderTraversalWithStack();
        System.out.println(tree);
        List<Integer> integers = inOrderTraversal.inorderTraversal(tree.root);
        System.out.println(integers);
        assertArrayEquals(new int[]{4, 2, 5, 1, 6, 3, 7}, integers.stream().mapToInt(i -> i).toArray());
    }
}