package com.github.algo.graph;

import java.util.HashMap;
import java.util.Map;

public class RedundantConnection {

    private int findParent(int node, Map<Integer, Integer> parent) {
        while (parent.get(node) != node) {
            parent.put(node, parent.get(node));
            node = parent.get(node);
        }
        return node;
    }

    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, Integer> rank = new HashMap<>();

        for (int[] edge : edges) {
            parent.putIfAbsent(edge[0], edge[0]);
            parent.putIfAbsent(edge[1], edge[1]);
            rank.putIfAbsent(edge[0], 1);
            rank.putIfAbsent(edge[1], 1);
            int parent1 = findParent(edge[0], parent);
            int parent2 = findParent(edge[1], parent);
            if (parent1 != parent2) {
                if (rank.get(parent1) < rank.get(parent2)) {
                    parent.put(parent1, parent2);
                    rank.put(parent2, rank.get(parent2) + 1);
                } else {
                    parent.put(parent2, parent1);
                    rank.put(parent1, rank.get(parent1) + 1);
                }
            } else {
                return edge;
            }
        }
        return null;
    }

}
