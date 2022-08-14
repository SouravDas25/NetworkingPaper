package com.github.algo.commons;

import java.util.List;

public class NestedInteger {

    private final Object value;
    private final boolean isInteger;

    public NestedInteger(Integer value) {
        this.value = value;
        isInteger = true;
    }

    public NestedInteger(List<NestedInteger> value) {
        this.value = value;
        isInteger = false;
    }

    public boolean isInteger() {
        return isInteger;
    }

    public Integer getInteger() {
        return (Integer) value;
    }

    public List<NestedInteger> getList() {
        return (List<NestedInteger>) value;
    }
}
