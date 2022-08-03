package com.github.algo.intervals;

import java.util.*;

public class MyCalendarI {

    TreeMap<Integer, Integer> calendar;
    public MyCalendarI() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer floorKey = calendar.floorKey(start);
        if (floorKey != null && calendar.get(floorKey) > start) return false;

        Integer ceilKey = calendar.ceilingKey(start);
        if(ceilKey !=null && ceilKey < end)
            return false;

        calendar.put(start, end);
        return true;
    }
}
