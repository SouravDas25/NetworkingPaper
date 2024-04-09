package com.github.algo.trees;

public class BalancedBinaryTree {

    boolean isBal = true;

    int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        isBal = isBal && Math.abs(leftDepth - rightDepth) <= 1;
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        maxDepth(root);
        return isBal;
    }
}
