package com.github.algo.trees;

public class ValidateBinarySearchTree {

    boolean isvbst(TreeNode<Integer> node, long min, long max) {
        if (node == null) return true;
        if (node.value >= max || node.value <= min) return false;
        long new_min = Math.max(min, node.value);
        long new_max = Math.min(max, node.value);
        return isvbst(node.left, min, new_max) &&
                isvbst(node.right, new_min, max);
    }

    public boolean isValidBST(TreeNode<Integer> root) {
        return isvbst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
