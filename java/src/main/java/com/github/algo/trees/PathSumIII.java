package com.github.algo.trees;

public class PathSumIII {

    private int pathSum3(TreeNode<Integer> root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (targetSum == root.value) {
            count++;
        }
        count += pathSum3(root.left, targetSum - root.value);
        count += pathSum3(root.right, targetSum - root.value);
        return count;
    }

    public int pathSum(TreeNode<Integer> root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        count += pathSum(root.left, targetSum) + pathSum(root.right, targetSum) + pathSum3(root, targetSum);
        return count;
    }

}
