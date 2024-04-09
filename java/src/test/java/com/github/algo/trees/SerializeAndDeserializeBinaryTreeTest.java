package com.github.algo.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SerializeAndDeserializeBinaryTreeTest {

    @Test
    void serialize() {
        BinaryTree<Integer> tree = BinaryTree.generateTree(3, 1, 6, 0, 2, 5, 7);
        SerializeAndDeserializeBinaryTree strConverter = new SerializeAndDeserializeBinaryTree();
        System.out.println(tree);
        String serialize = strConverter.serialize(tree.root);
        System.out.println(serialize);

        TreeNode deserializedTree = strConverter.deserialize(serialize);
        BinaryTree tree1 = new BinaryTree();
        tree1.root = deserializedTree;
        System.out.println(tree1);
    }
}