package com.github.algo.stack;

import java.util.Stack;

public class MaximumNestingDepthOfTheParentheses {

    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int depth = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push('(');
            if (c == ')') stack.pop();
            depth = Math.max(stack.size(), depth);
        }
        return stack.isEmpty() ? depth : 0;
    }

}
