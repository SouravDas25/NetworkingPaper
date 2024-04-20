package com.github.algo.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JumpGameIITest {

    @Test
    void jump() {
        JumpGameII jumpGameII = new JumpGameII();
        int jump = jumpGameII.jump(new int[]{2, 3, 1, 1, 4});
        assertEquals(2, jump);
    }

    @Test
    void jump1() {
        JumpGameII jumpGameII = new JumpGameII();
        int jump = jumpGameII.jump(new int[]{2, 3, 0, 1, 4});
        assertEquals(2, jump);
    }
}