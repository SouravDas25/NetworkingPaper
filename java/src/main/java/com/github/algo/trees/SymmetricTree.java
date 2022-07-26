package com.github.algo.trees;

import java.util.*;

public class SymmetricTree {

    private boolean isSymmetric(TreeNode<Integer> left, TreeNode<Integer> right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (!Objects.equals(left.value, right.value)) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return isSymmetric(root.left, root.right);
    }
}
