package com.github.algo.commons;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;


public class NestedIterator implements Iterator<Integer> {

    private final Iterator<Integer> iterator;

    private static Stream<Integer> flatMap(NestedInteger nestedInteger) {
        if (nestedInteger.isInteger()) {
            return Stream.of(nestedInteger.getInteger());
        } else {
            return nestedInteger.getList().stream().flatMap(NestedIterator::flatMap);
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        iterator = nestedList.stream().flatMap(NestedIterator::flatMap).iterator();
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
}
