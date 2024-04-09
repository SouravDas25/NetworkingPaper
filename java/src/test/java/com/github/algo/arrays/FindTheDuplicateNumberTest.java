package com.github.algo.arrays;

import com.github.algo.linkedlist.FindTheDuplicateNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindTheDuplicateNumberTest {

    @Test
    void findDuplicate() {
        FindTheDuplicateNumber f = new FindTheDuplicateNumber();
        assertEquals(3, f.findDuplicate(new int[]{3, 3, 3, 3, 3}));
    }

    @Test
    void findDuplicate1() {
        FindTheDuplicateNumber f = new FindTheDuplicateNumber();
        assertEquals(2, f.findDuplicate(new int[]{1, 2, 3, 4, 2}));
    }

    @Test
    void findDuplicate2() {
        FindTheDuplicateNumber f = new FindTheDuplicateNumber();
        assertEquals(9, f.findDuplicate(new int[]{2, 5, 9, 6, 9, 3, 8, 9, 7, 1}));
    }
}