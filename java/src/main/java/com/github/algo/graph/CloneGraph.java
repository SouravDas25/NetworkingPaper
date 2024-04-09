package com.github.algo.graph;

import java.util.*;


public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, List<Integer>> neighborMap = new HashMap<>();
        Deque<Node> queue = new LinkedList<>();
        queue.addLast(node);
        while (!queue.isEmpty()) {
            Node current = queue.removeFirst();
            if (neighborMap.containsKey(current.val)) {
                continue;
            }
            neighborMap.putIfAbsent(current.val, new LinkedList<>());
            for (Node neighbor : current.neighbors) {
                neighborMap.get(current.val).add(neighbor.val);
                queue.addLast(neighbor);
            }
        }
        Map<Integer, Node> map = new HashMap<>();
        for (Integer val : neighborMap.keySet()) {
            map.put(val, new Node(val));
        }
        for (Integer val : neighborMap.keySet()) {
            Node current = map.get(val);
            for (Integer neighbor : neighborMap.get(val)) {
                current.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node.val);
    }


}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}