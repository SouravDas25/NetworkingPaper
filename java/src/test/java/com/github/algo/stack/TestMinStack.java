package com.github.algo.stack;


import com.github.algo.stack.MinStack;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestMinStack {

    @Test
    public void minStackTest() {
        MinStack minStack = new MinStack();
        minStack.push(3);
        assertThat(minStack.min()).isEqualTo(3);
        minStack.push(2);
        assertThat(minStack.min()).isEqualTo(2);
        minStack.push(4);
        assertThat(minStack.min()).isEqualTo(2);
        minStack.push(5);
        assertThat(minStack.min()).isEqualTo(2);
        minStack.push(1);
        assertThat(minStack.min()).isEqualTo(1);


        Integer value = minStack.pop();
        assertThat(value).isEqualTo(1);
        assertThat(minStack.min()).isEqualTo(2);

        value = minStack.pop();
        assertThat(value).isEqualTo(5);
        assertThat(minStack.min()).isEqualTo(2);

        value = minStack.pop();
        assertThat(value).isEqualTo(4);
        assertThat(minStack.min()).isEqualTo(2);

        value = minStack.pop();
        assertThat(value).isEqualTo(2);
        assertThat(minStack.min()).isEqualTo(3);

        value = minStack.pop();
        assertThat(value).isEqualTo(3);
    }
}
