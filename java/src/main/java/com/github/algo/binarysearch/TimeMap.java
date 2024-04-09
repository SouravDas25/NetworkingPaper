package com.github.algo.binarysearch;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {
    Map<String, TreeMap<Integer, String>> keyMap = new HashMap<>();

    public TimeMap() {
    }

    public void set(String key, String value, int timestamp) {
        keyMap.putIfAbsent(key, new TreeMap<>());
        TreeMap<Integer, String> valueMap = keyMap.get(key);
        valueMap.put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (keyMap.containsKey(key)) {
            TreeMap<Integer, String> valueMap = keyMap.get(key);
            Map.Entry<Integer, String> entry = valueMap.floorEntry(timestamp);
            if (entry != null) {
                return entry.getValue();
            }
        }
        return "";
    }
}
