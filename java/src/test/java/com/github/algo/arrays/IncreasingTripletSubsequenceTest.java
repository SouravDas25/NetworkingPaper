package com.github.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncreasingTripletSubsequenceTest {

    @Test
    void increasingTriplet() {
        IncreasingTripletSubsequence increasingTripletSubsequence = new IncreasingTripletSubsequence();
        boolean b = increasingTripletSubsequence.increasingTriplet(new int[]{2,1,5,0,4,6});
        System.out.println(b);
    }

}