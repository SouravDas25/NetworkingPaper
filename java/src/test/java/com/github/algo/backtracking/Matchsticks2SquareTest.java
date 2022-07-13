package com.github.algo.backtracking;

import com.github.algo.backtracking.Matchsticks2Square;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Matchsticks2SquareTest {

    @Test
    void makesquare() {
        int[] matchticks = {308,435,201,196,360,637,292,326,405,319,334,563,824,511,393};
        Matchsticks2Square matchsticks2Square = new Matchsticks2Square();
        boolean makesquare = matchsticks2Square.makesquare(matchticks);
        System.out.println(makesquare);
//        Assertions.assertThat(makesquare).isTrue();

    }

    @Test
    void makesquare_POS() {
        int[] matchticks = {1,1,2,2,2};
        Matchsticks2Square matchsticks2Square = new Matchsticks2Square();
        boolean makesquare = matchsticks2Square.makesquare(matchticks);
        System.out.println(makesquare);
        Assertions.assertThat(makesquare).isTrue();

    }

    @Test
    void makesquare_NEG() {
        int[] matchticks = {3,3,3,3,4};
        Matchsticks2Square matchsticks2Square = new Matchsticks2Square();
        boolean makesquare = matchsticks2Square.makesquare(matchticks);
        System.out.println(makesquare);
        Assertions.assertThat(makesquare).isFalse();

    }
}