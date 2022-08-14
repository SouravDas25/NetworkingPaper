package com.github.algo.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BullsandCowsTest {

    @Test
    void getHint() {
        BullsandCows bullsandCows = new BullsandCows();
        String hint = bullsandCows.getHint("1123", "0111");
        System.out.println(hint);

    }
}