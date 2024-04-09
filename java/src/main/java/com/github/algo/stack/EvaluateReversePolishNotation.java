package com.github.algo.stack;

import java.util.Deque;
import java.util.LinkedList;

public class EvaluateReversePolishNotation {

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str); // or Integer.valueOf(str)
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if (isInteger(token)) {
                stack.push(Integer.valueOf(token));
            } else {
                char op = token.charAt(0);
                int val1 = stack.pop();
                int val2 = stack.pop();
                int output = switch (op) {
                    case '+' -> val2 + val1 ;
                    case '-' -> val2 - val1;
                    case '*' -> val2 * val1;
                    case '/' -> val2 / val1;
                    default -> 0;
                };
                stack.push(output);
            }
        }
        return stack.pop();
    }

}
