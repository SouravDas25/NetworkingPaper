package com.github.algo.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeMapTest {

    @Test
    void testcase1() {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);

        String value = timeMap.get("foo", 1);
        assertEquals("bar", value);
        value = timeMap.get("foo", 3);
        assertEquals("bar", value);

        timeMap.set("foo", "bar2", 4);

        value = timeMap.get("foo", 4);
        assertEquals("bar2", value);
        value = timeMap.get("foo", 5);
        assertEquals("bar2", value);
    }

    @Test
    void testcase2() {
        TimeMap timeMap = new TimeMap();
        timeMap.set("love", "high", 10);
        timeMap.set("love", "low", 20);

        String value = timeMap.get("love", 5);
        assertEquals("", value);
        value = timeMap.get("love", 10);
        assertEquals("high", value);


        value = timeMap.get("love", 15);
        assertEquals("high", value);
        value = timeMap.get("love", 20);
        assertEquals("low", value);
        value = timeMap.get("love", 25);
        assertEquals("low", value);
    }
}