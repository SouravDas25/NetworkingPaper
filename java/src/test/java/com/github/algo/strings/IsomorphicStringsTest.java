package com.github.algo.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsomorphicStringsTest {

    @Test
    void isIsomorphic() {
        IsomorphicStrings isomorphicStrings= new IsomorphicStrings();
        boolean isomorphic = isomorphicStrings.isIsomorphic("add", "egg");
        System.out.println(isomorphic);
    }
}