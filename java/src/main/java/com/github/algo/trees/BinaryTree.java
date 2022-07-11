package com.github.algo.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class BinaryTree<T> {

    public TreeNode<T> root;

    private void printNode(TreeNode<T> node, String prefix, String chprefix, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(prefix).append(node.value).append("\n");
        printNode(node.left, chprefix + "├── ", chprefix + "│   ", sb);
        printNode(node.right, chprefix + "└── ", chprefix + "    ", sb);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        printNode(root, "", "", sb);
        return sb.toString();
    }

    public static <T> BinaryTree<T> generateTree(T... items) {
        Queue<T> values = Arrays.stream(items).collect(Collectors.toCollection(LinkedList::new));
        BinaryTree<T> binaryTree = new BinaryTree<>();
        binaryTree.root = new TreeNode<>(values.poll());
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(binaryTree.root);

        while (!values.isEmpty()) {
            TreeNode<T> node = queue.poll();
            T val1 = values.isEmpty() ? null : values.poll();
            T val2 = values.isEmpty() ? null : values.poll();

            if (val1 != null) {
                node.left = new TreeNode<>(val1);
                queue.add(node.left);
            }

            if (val2 != null) {
                node.right = new TreeNode<>(val2);
                queue.add(node.right);
            }
        }
        return binaryTree;
    }

}
