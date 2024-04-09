package com.github.algo.trees;

public class DiameterOfBinaryTree {

    int maxDiameter = 0;

    int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
//        maxDiameter = Math.max(maxDiameter, maxDepth(root));
        maxDepth(root);
        return maxDiameter;
    }
}
