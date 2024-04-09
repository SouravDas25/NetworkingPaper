package com.github.algo.trees;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SerializeAndDeserializeBinaryTree {

    void recser(TreeNode node, List<String> result) {
        if (node == null) {
            result.add("#");
            return;
        }
        result.add(String.valueOf(node.value));
        recser(node.left, result);
        recser(node.right, result);
    }

    public String serialize(TreeNode root) {
        List<String> result = new LinkedList<>();
        recser(root, result);
        return String.join(",", result);
    }

    TreeNode recdes(Deque<String> result) {
        if (result.size() < 0) {
            return null;
        }
        String stringValue = result.removeFirst();
        if (stringValue.contains("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(stringValue));
        node.left = recdes(result);
        node.right = recdes(result);
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        Deque<String> values = Arrays.stream(data.split(","))
                .collect(Collectors.toCollection(LinkedList::new));
        TreeNode root = recdes(values);
        return root;
    }
}
