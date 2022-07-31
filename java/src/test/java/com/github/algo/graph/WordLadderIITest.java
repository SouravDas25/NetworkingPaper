package com.github.algo.graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordLadderIITest {

    @Test
    void findLadders() {
        WordLadderII wordLadderII = new WordLadderII();
        List<List<String>> ladders = wordLadderII.findLadders("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(ladders);
    }
}