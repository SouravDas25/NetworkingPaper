package com.github.algo.trees;

import java.util.*;

public class ZigZagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return Collections.emptyList();
        }
        List<TreeNode> level = new LinkedList<>();
        level.add(root);

        List<List<Integer>> outputList = new ArrayList<>();
        boolean reverse = false;
        while (!level.isEmpty()) {
            LinkedList<TreeNode> nextLevel = new LinkedList<>();
            List<Integer> values = new ArrayList<>();
            for (TreeNode<Integer> node : level) {
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
                values.add(node.value);
            }
            if (reverse) {
                Collections.reverse(values);
            }
            reverse = !reverse;
            level = nextLevel;
            outputList.add(values);
        }
        return outputList;
    }

}
