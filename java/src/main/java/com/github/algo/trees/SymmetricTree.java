package com.github.algo.trees;

import java.util.*;

public class SymmetricTree {



    private void inOrder(TreeNode<Integer> node, List<String> output) {
        if (node == null) {
            output.add("#");
            return;
        }
        inOrder(node.left, output);
        output.add(node.value.toString());
        inOrder(node.right, output);
    }

    public boolean isSymmetric(TreeNode root) {
        List<String> left = new LinkedList<>();
        inOrder(root.left, left);
        List<String> right = new LinkedList<>();
        inOrder(root.right, right);
        Collections.reverse(right);
        return left.equals(right);
    }
}
