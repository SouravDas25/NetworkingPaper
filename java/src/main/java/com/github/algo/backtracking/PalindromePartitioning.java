package com.github.algo.backtracking;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private void dfs(int i, String s, Deque<String> partitions, List<List<String>> output) {
        if (i == s.length()) {
            output.add(List.copyOf(partitions));
        }
        for (int j = i; j < s.length(); j++) {
            String substring = s.substring(i, j+1);
            if (!isPalindrome(substring)) {
                continue;
            }
            partitions.addLast(substring);
            dfs(j + 1, s, partitions, output);
            partitions.removeLast();
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> output = new LinkedList<>();
        dfs(0, s, new LinkedList<>(), output);
        return output;
    }
}
