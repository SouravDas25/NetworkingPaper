package com.github.algo.strings;

import com.github.algo.strings.DecodeString;
import org.junit.jupiter.api.Test;

class DecodeStringTest {

    @Test
    void decodeString() {
        DecodeString decodeString = new DecodeString();
        String s = decodeString.decodeString("2[abc]3[cd]ef");
        System.out.println(s);
    }
}