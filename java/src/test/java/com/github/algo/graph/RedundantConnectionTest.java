package com.github.algo.graph;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RedundantConnectionTest {

    @Test
    void findRedundantConnection() {
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        RedundantConnection redundantConnection = new RedundantConnection();
        int[] redundantConnection1 = redundantConnection.findRedundantConnection(edges);
        System.out.println(Arrays.toString(redundantConnection1));
    }
}