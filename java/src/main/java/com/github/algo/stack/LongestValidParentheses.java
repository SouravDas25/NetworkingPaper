package com.github.algo.stack;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class LongestValidParentheses {

    private int getDp(int[] dp, int index) {
        return dp[index + 1];
    }

    private void setDp(int[] dp, int index, int value) {
        dp[index + 1] = value;
    }

    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, 0);
        Deque<Character> stack = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    if (s.charAt(i - 1) == '(') {
                        int val = getDp(dp, i - 2) + 2;
                        setDp(dp, i, val);
                    } else {
                        int val = getDp(dp, i - 1) + 2;
                        setDp(dp, i, val + getDp(dp, i - val));
                    }
                }
            }
            max = Math.max(max, getDp(dp, i));
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }
}
