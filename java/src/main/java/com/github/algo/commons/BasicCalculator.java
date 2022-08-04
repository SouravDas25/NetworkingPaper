package com.github.algo.commons;

import java.util.*;

public class BasicCalculator {


    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    static boolean isOperator(char ch) {
        switch (ch) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
                return true;
            default:
                return false;
        }
    }

    public static int eval(int a, int b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            case '^':
                return (int) Math.pow(a, b);
            default:
                return 0;
        }
    }

    static boolean isNegativeNumber(int i, String exp) {
        return exp.charAt(i) == '-' && (i == 0 || exp.charAt(i - 1) == '(' || isOperator(exp.charAt(i - 1))) && i + 1 < exp.length() && Character.isDigit(exp.charAt(i + 1));
    }

    private static boolean isNegativeUnitary(int i, String exp) {
        return exp.charAt(i) == '-' && (i == 0 || exp.charAt(i - 1) == '(' || isOperator(exp.charAt(i - 1)));
    }

    static List<String> infixToPostfix(String exp) {
        // initializing empty String for result
        List<String> result = new LinkedList<>();

        // initializing empty stack
        Deque<Character> stack = new LinkedList<>();

        int i = 0;
        while (i < exp.length()) {
            char c = exp.charAt(i);
            if (Character.isDigit(c) || isNegativeNumber(i, exp)) {
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                while (i + 1 < exp.length() && Character.isDigit(exp.charAt(i + 1))) {
                    sb.append(exp.charAt(i + 1));
                    i++;
                }
                result.add(sb.toString());
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.add(stack.pop().toString());
                }
                stack.pop();
            } else if (isOperator(c)) {
                if (isNegativeUnitary(i, exp)) {
                    result.add("0");
                }
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.add(stack.pop().toString());
                }
                stack.push(c);
            }
            i++;
        }
        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return null;
            }
            result.add(stack.pop().toString());
        }
        return result;
    }


    public int evaluate(List<String> postfix) {
        Deque<Integer> stack = new LinkedList<>();
        for (String op : postfix) {
            if (isOperator(op.charAt(0)) && op.length() == 1) {
                int b = stack.isEmpty() ? 0 : stack.pop();
                int a = stack.isEmpty() ? 0 : stack.pop();
                stack.push(eval(a, b, op.charAt(0)));
            } else {
                stack.push(Integer.parseInt(op));
            }
        }
        return stack.pop();
    }

    public int calculate(String s) {
        s = s.replace(" ", "");
        List<String> split = infixToPostfix(s);
        System.out.println(split);
        int evaluate = evaluate(split);
        System.out.println(evaluate);
        return evaluate;

    }

}
