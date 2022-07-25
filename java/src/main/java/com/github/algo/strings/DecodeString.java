package com.github.algo.strings;

import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class DecodeString {

    private String convert2postfix(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                sb.append(",");
            } else if (ch == ']') {
                sb.append("*");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    private String evaluatePostfix(String postfix) {
        LinkedList<Object> stack = new LinkedList<>();
        int i = 0;
        while (i < postfix.length()) {
            char ch = postfix.charAt(i);
            if (ch == '*') {
                StringBuilder op2 = new StringBuilder((String) stack.pop());
                Object op1 = stack.pop();
                while (!(op1 instanceof Integer)) {
                    op2.insert(0, op1);
                    op1 = stack.pop();
                }
                int n = (Integer) op1;
                String op = op2.toString();
                for (int j = 0; j < n - 1; j++) {
                    op2.append(op);
                }
                stack.push(op2.toString());
            } else if (Character.isDigit(ch)) {
                int index = postfix.indexOf(",", i);
                stack.push(Integer.parseInt(postfix.substring(i, index)));
                i = index;
            } else {
                stack.push(String.valueOf(ch));
            }
            i++;
        }
        Collections.reverse(stack);
        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public String decodeString(String s) {
        s = convert2postfix(s);
        System.out.println(s);
        return evaluatePostfix(s);
    }

}
