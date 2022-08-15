package com.github.algo.hashing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomHashSetTest {

    @Test
    void hashSet() {
        CustomHashSet<Integer> hashSet = new CustomHashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(1);
        System.out.println(hashSet);

    }
}