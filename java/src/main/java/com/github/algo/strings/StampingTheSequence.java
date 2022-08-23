package com.github.algo.strings;

import org.javatuples.Pair;

import java.util.*;

public class StampingTheSequence {


    private void findMatching(String stamp, String target, PriorityQueue<Pair<Integer, Integer>> matches, Set<Integer> visited) {
        for (int i = 0; i < target.length(); i++) {
            int matchCount = 0;
            boolean atLeastOneCharMatch = false;
            for (int j = 0; j < stamp.length(); j++) {
                if (visited.contains(i) || i + j >= target.length()) {
                    break;
                }
                if (stamp.charAt(j) == target.charAt(i + j) || target.charAt(i + j) == '?') {
                    matchCount++;
                    atLeastOneCharMatch = atLeastOneCharMatch || target.charAt(i + j) != '?';
                } else {
                    break;
                }
            }
            if (matchCount == stamp.length() && atLeastOneCharMatch) {
                matches.add(Pair.with(matchCount, i));
                visited.add(i);
                i += matchCount - 1;
            }
        }
    }

    private String stampTarget(String stamp, String target, int startFrom) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            if (i >= startFrom && i < startFrom + stamp.length()) {
                sb.append('?');
            } else {
                sb.append(target.charAt(i));
            }
        }
        return sb.toString();
    }

    public int[] movesToStamp(String stamp, String target) {
        int matched = 0;
        PriorityQueue<Pair<Integer, Integer>> matches = new PriorityQueue<>(Comparator.reverseOrder());
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> stack = new LinkedList<>();
        while (matched < target.length()) {
            findMatching(stamp, target, matches, visited);
            if (matches.isEmpty()) {
                break;
            }
            Pair<Integer, Integer> poll = matches.poll();
            target = stampTarget(stamp, target, poll.getValue1());
            int nm = (int) target.chars().filter(i -> i == '?').count();
            if (nm != matched) {
                stack.push(poll.getValue1());
                matched = nm;
                System.out.println("" + target + "," + matched);
            }
        }
        if (matched != target.length()) {
            return new int[0];
        }
        int[] output = new int[stack.size()];
        int count = 0;
        while (!stack.isEmpty()) {
            output[count] = stack.pop();
            count++;
        }
        return output;
    }

}
