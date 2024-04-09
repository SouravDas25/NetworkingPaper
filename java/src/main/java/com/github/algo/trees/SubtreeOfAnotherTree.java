package com.github.algo.trees;

public class SubtreeOfAnotherTree {

    boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.value != q.value) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        boolean isSt = isSameTree(root, subRoot);
        if (isSt) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
