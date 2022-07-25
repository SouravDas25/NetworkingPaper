package com.github.algo.trees;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    private void inOrder(TreeNode<Integer> node, List<Integer> output) {
        if (node == null) return;
        inOrder(node.left, output);
        output.add(node.value);
        inOrder(node.right, output);
    }

    public List<Integer> inorderTraversal(TreeNode<Integer> root) {
        List<Integer> output = new LinkedList<>();
        inOrder(root, output);
        return output;
    }

}
