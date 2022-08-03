package com.github.algo.intervals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyCalendarITest {

    @Test
    void book() {
        MyCalendarI myCalendarI = new MyCalendarI();
        myCalendarI.book(10, 20);
        assert !myCalendarI.book(15, 25);
        assert myCalendarI.book(20, 30);
    }
}