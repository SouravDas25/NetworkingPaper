package com.github.algo.trees;

public class TreeNode<T> {
    TreeNode<T> left;
    TreeNode<T> right;
    T value;

    public TreeNode(TreeNode<T> left, TreeNode<T> right, T value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public TreeNode(T value) {
        this.value = value;
    }
}
