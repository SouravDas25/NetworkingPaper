package com.github.algo.vaarg;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class VaArgExample {

    static void print(Object... objects) {
        List<String> list = Arrays.stream(objects).map(Object::toString).toList();
        System.out.println(String.join(", ", list));
    }
}
