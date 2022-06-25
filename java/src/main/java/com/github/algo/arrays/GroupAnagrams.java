package com.github.algo.arrays;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(List<String> strs) {
        Map<String, List<String>> groupedAnagram = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);
            groupedAnagram.putIfAbsent(sortedStr, new ArrayList<>());
            groupedAnagram.get(sortedStr).add(s);
        }
        List<List<String>> allAnagrams = new ArrayList();
        groupedAnagram.forEach( (key,value) -> allAnagrams.add(value));
        return allAnagrams;
    }
}
