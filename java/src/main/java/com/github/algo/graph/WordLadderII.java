package com.github.algo.graph;

import com.github.algo.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class WordLadderII {


    private boolean wordDifferenceByOne(String a, String b) {
        if (Math.abs(a.length() - b.length()) > 1) return false;
        int count = 0;
        int i = 0;
        while (i < a.length() || i < b.length()) {
            if (i < a.length() && i < b.length()) {
                if (a.charAt(i) != b.charAt(i)) {
                    count++;
                }
            } else {
                count++;
            }
            if (count > 1) return false;
            i++;
        }
        return count == 1;
    }

    private Map<String, List<String>> buildGraph(Set<String> wordList) {
        Map<String, List<String>> adjList = new HashMap<>();
        for (String a : wordList) {
            adjList.putIfAbsent(a, new LinkedList<>());
            for (String s : wordList) {
                if (wordDifferenceByOne(a, s)) {
                    adjList.get(a).add(s);
                }
            }
        }
        return adjList;
    }

    private Map<String, List<String>> adjList;
    private String endWord;

    private void dfs(String currentWord, LinkedHashSet<String> current, List<List<String>> output) {
        if (currentWord.equals(endWord)) {
            current.add(endWord);
            if (!output.isEmpty() && current.size() > output.get(0).size()) {
                current.remove(endWord);
                return;
            }
            if (!output.isEmpty() && current.size() < output.get(0).size()) {
                output.clear();
            }
            output.add(List.copyOf(current));
            current.remove(endWord);
            return;
        }
        if (current.contains(currentWord)) {
            return;
        }
        current.add(currentWord);
        for (String edge : adjList.get(currentWord)) {
            dfs(edge, current, output);
        }
        current.remove(currentWord);
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.add(beginWord);
        this.adjList = buildGraph(wordSet);
        this.endWord = endWord;
        System.out.println(adjList);
        List<List<String>> output = new LinkedList<>();
        dfs(beginWord, new LinkedHashSet<>(), output);
        return output;
    }

}
