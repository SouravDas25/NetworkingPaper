package com.github.algo.trees;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void generateTree() {
        BinaryTree<Integer> integerBinaryTree = BinaryTree.generateTree(1, 2, 3, null, null, 4, 5, 6, 7);
        System.out.println(integerBinaryTree);
    }
}