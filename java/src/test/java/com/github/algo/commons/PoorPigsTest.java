package com.github.algo.commons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PoorPigsTest {

    @Test
    void poorPigs() {
        PoorPigs poorPigs = new PoorPigs();
        int i = poorPigs.poorPigs(1000, 15, 60);
        System.out.println(i);
    }
}