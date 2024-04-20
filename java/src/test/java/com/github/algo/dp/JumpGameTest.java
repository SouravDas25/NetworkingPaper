package com.github.algo.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JumpGameTest {

    @Test
    void canJump() {
        JumpGame game = new JumpGame();
        boolean b = game.canJump(new int[]{2, 3, 1, 1, 4});
        assertTrue(b);
    }

    @Test
    void canJump1() {
        JumpGame game = new JumpGame();
        boolean b = game.canJump(new int[]{2, 3, 0, 1, 4});
        assertTrue(b);
    }

    @Test
    void canJump2() {
        JumpGame game = new JumpGame();
        boolean b = game.canJump(new int[]{0});
        assertTrue(b);
    }
}