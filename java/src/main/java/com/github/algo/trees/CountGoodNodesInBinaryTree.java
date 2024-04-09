package com.github.algo.trees;

public class CountGoodNodesInBinaryTree {

    int gn(TreeNode<Integer> node, int max) {
        if (node == null) return 0;
        if (node.value >= max) {
            // good node
            return gn(node.left, node.value) + gn(node.right, node.value) + 1;
        } else {
            return gn(node.left, max) + gn(node.right, max);
        }
    }

    public int goodNodes(TreeNode root) {
        return gn(root, Integer.MIN_VALUE);
    }
}
