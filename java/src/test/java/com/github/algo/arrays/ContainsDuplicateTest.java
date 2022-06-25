package com.github.algo.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ContainsDuplicateTest {

    @Test
    public void test() {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        boolean b = containsDuplicate.containsDuplicate(new int[]{1,2,3,4,5});
        assertThat(b).isFalse();


        b = containsDuplicate.containsDuplicate(new int[]{1,2,2,4,5});
        assertThat(b).isTrue();
    }

}