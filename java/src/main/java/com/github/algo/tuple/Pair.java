package com.github.algo.tuple;

import java.util.Objects;

public class Pair<A, B> {
    private final A val0;
    private final B val1;

    public static <A, B> Pair<A, B> with(A value0, B value1) {
        return new Pair(value0, value1);
    }

    public Pair(A value0, B value1) {
        this.val0 = value0;
        this.val1 = value1;
    }

    public A getValue0() {
        return this.val0;
    }

    public B getValue1() {
        return this.val1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(val0, pair.val0) && Objects.equals(val1, pair.val1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val0, val1);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "val0=" + val0 +
                ", val1=" + val1 +
                '}';
    }
}
