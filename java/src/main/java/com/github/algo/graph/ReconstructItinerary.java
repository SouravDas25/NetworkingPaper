package com.github.algo.graph;

import java.util.*;

public class ReconstructItinerary {

    private void dfs(String src, Map<String, LinkedList<String>> placeMap, List<String> current) {
        while (placeMap.containsKey(src) && !placeMap.get(src).isEmpty()) {
            dfs(placeMap.get(src).removeFirst(), placeMap, current);
        }
        current.add(src);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, LinkedList<String>> placeMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            placeMap.putIfAbsent(ticket.get(0), new LinkedList<>());
            placeMap.putIfAbsent(ticket.get(1), new LinkedList<>());
            placeMap.get(ticket.get(0)).add(ticket.get(1));
        }
        for (String src : placeMap.keySet()) {
            Collections.sort(placeMap.get(src));
        }
        List<String> output = new LinkedList<>();
        dfs("JFK", placeMap, output);
        Collections.reverse(output);
        return output;
    }
}
