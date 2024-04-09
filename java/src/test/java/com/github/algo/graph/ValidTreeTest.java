package com.github.algo.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidTreeTest {

    @Test
    void validTree() {
        ValidTree tree = new ValidTree();
        int [][] edges = {{0,1}, {1,2}, {2,3}, {3,4}};
        boolean b = tree.validTree(5, edges);
        assertTrue(b);
    }
}