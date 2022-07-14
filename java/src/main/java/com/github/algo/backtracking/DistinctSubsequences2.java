package com.github.algo.backtracking;

import java.util.*;

public class DistinctSubsequences2 {


    private void dfs(int i, String s, Set<String> output, String current) {
        for (int j = i; j < s.length(); j++) {
            dfs(j + 1, s, output, current + s.charAt(j));
        }
        output.add(current);
    }

    public int distinctSubseqII(String s) {
        Set<String> output = new HashSet<>();
        dfs(0, s, output, "");
        System.out.println(output);
        return output.size() - 1;
    }

}
