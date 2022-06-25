package com.github.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {

    @Test
    void isAnagram() {
        Anagram anagram = new Anagram();
        boolean b = anagram.isAnagram("anagram", "nagaram");
        assertThat(b).isTrue();

        b = anagram.isAnagram("rat", "car");
        assertThat(b).isFalse();
    }
}