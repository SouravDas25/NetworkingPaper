package com.github.algo.util;

public class ArrayConverter {

    public String convertToJavaArray(String value) {
        StringBuilder sb = new StringBuilder();
        for (Character ch : value.toCharArray()) {
            if (ch == '[') {
                sb.append("{");
            } else if (ch == ']') {
                sb.append("}");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
