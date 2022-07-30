package com.github.algo.backtracking;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {

    private void rec(int left, int right, Deque<String> current, List<String> output) {
        if (left <= 0 && right <= 0) {
            output.add(String.join("", current));
        }
        if (left > 0) {
            current.add("(");
            rec(left - 1, right + 1, current, output);
            current.removeLast();
        }
        if(right > 0) {
            current.add(")");
            rec(left, right-1, current, output);
            current.removeLast();
        }
    }

    public List<String> generateParenthesis(int n) {
        Deque<String> current = new LinkedList<>();
        List<String> output = new LinkedList<>();
        rec(n, 0 , current, output);
        return output;
    }
}
