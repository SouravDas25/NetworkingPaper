package com.github.algo.trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        List<TreeNode> level = new LinkedList<>();
        level.add(root);
        while (!level.isEmpty()) {
            List<TreeNode> nextLevel = new LinkedList<>();
            Deque<Integer> output = new LinkedList<>();
            for (TreeNode<Integer> node : level) {
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
                output.add(node.value);
            }
            result.add(output.removeLast());
            level = nextLevel;
        }
        return result;
    }

}
