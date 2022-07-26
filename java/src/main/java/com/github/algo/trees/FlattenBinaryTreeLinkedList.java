package com.github.algo.trees;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class FlattenBinaryTreeLinkedList {

    private void preOrder(TreeNode<Integer> root, Deque<Integer> integers) {
        if (root == null) return;
        integers.add(root.value);
        preOrder(root.left, integers);
        preOrder(root.right, integers);
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<Integer> integers = new LinkedList<>();
        preOrder(root, integers);
        integers.removeFirst();
        root.left = null;
        root.right = null;
        TreeNode current = root;
        while (!integers.isEmpty()) {
            current.left = null;
            current.right = new TreeNode(integers.removeFirst());
            current = current.right;
        }
    }

}
