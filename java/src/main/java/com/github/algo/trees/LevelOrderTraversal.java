package com.github.algo.trees;

import java.util.*;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode<Integer> root) {
        if(root == null) {
            return Collections.emptyList();
        }
        List<TreeNode<Integer>> level = new LinkedList<>();
        level.add(root);
        List<List<Integer>> outputList = new ArrayList<>();
        while (!level.isEmpty()) {
            List<TreeNode<Integer>> nextLevel = new LinkedList<>();
            List<Integer> values = new ArrayList<>();
            for (TreeNode<Integer> node : level) {
                if (node.left != null){
                    nextLevel.add(node.left);
                }
                if (node.right != null){
                    nextLevel.add(node.right);
                }
                values.add(node.value);
            }
            outputList.add(values);
            level = nextLevel;
        }
        return outputList;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode<Integer> root) {
        List<List<Integer>> lists = this.levelOrder(root);
        Collections.reverse(lists);
        return lists;
    }
}
