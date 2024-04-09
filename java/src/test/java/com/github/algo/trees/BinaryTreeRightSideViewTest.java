package com.github.algo.trees;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeRightSideViewTest {

    @Test
    void rightSideView() {
        BinaryTreeRightSideView rightSideView = new BinaryTreeRightSideView();
        BinaryTree<Integer> tree = BinaryTree.generateTree(1, 2, 3, null, 5, null, 4);
        List<Integer> integers = rightSideView.rightSideView(tree.root);
        System.out.println(integers);
    }
}