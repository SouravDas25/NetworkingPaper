package com.github.algo.stack;


import java.util.Objects;
import java.util.Stack;

public class MinStack {

    public Stack<Integer> stack = new Stack<>();
    public Stack<Integer> minStack = new Stack<>();

    public void push(Integer value) {
        if (this.stack.empty() || this.stack.peek() > value) {
            this.minStack.push(value);
        }
        this.stack.push(value);
    }

    public Integer pop() {
        if (Objects.equals(this.stack.peek(), this.minStack.peek())) {
            this.minStack.pop();
        }
        return this.stack.pop();
    }

    public Integer min() {
        return this.minStack.peek();
    }
}


