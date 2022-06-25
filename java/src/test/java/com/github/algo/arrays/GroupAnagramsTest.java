package com.github.algo.arrays;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroupAnagramsTest {

    @Test
    void groupAnagrams() {
        GroupAnagrams groupAnagrams = new GroupAnagrams();

        List<String> strs = Arrays.asList("eat","tea","tan","ate","nat","bat");
        List<List<String>> lists = groupAnagrams.groupAnagrams(strs);
        System.out.println(lists);
    }
}