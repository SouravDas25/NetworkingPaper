package com.github.algo.strings;

import java.util.Deque;
import java.util.LinkedList;

public class BackspaceStringCompare {

    private String removeBackspace(String string) {
        LinkedList<String> stack = new LinkedList<>();
        for (char ch : string.toCharArray()) {
            if (ch == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(String.valueOf(ch));
            }
        }
        return String.join("", stack);
    }

    public boolean backspaceCompare(String s, String t) {
        s = removeBackspace(s);
        t = removeBackspace(t);
        return s.equals(t);
    }
}
