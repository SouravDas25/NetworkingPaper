package com.github.algo.graph;

import java.util.Arrays;

/*
 *
 * Valid Tree

Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

Example 1:

Input:
n = 5
edges = [[0, 1], [0, 2], [0, 3], [1, 4]]

Output:
true

Example 2:

Input:
n = 5
edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]

Output:
false

Note:

    You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Constraints:

    1 <= n <= 100
    0 <= edges.length <= n * (n - 1) / 2


 */
public class ValidTree {

    public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        Arrays.fill(rank, 1);
        for (int[] edge : edges) {
            parent[edge[0]] = edge[0];
            parent[edge[1]] = edge[1];

            int root0 = findRoot(edge[0], parent);
            int root1 = findRoot(edge[1], parent);

            if (root0 == root1) {
                return false;
            }
            if (rank[root0] > rank[root1]) {
                parent[edge[1]] = root0;
                rank[root0] += rank[root1];
            } else {
                parent[edge[0]] = root1;
                rank[edge[1]] += rank[root0];
            }

        }
        return true;
    }

    private int findRoot(int node, int[] parent) {
        while (node != parent[node]) {
            parent[node] = parent[parent[node]];
            node = parent[node];
        }
        return node;
    }

}
