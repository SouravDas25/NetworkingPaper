package com.github.algo.hashing;

public class CustomHashSet<V> {

    private CustomHashMap<V, V> set = new CustomHashMap<>();

    public void add(V value) {
        set.put(value, value);
    }

    public boolean contains(V value) {
        return set.contains(value);
    }

    public void remove(V value) {
        set.remove(value);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomHashSet{");
        sb.append("set=").append(set);
        sb.append('}');
        return sb.toString();
    }
}
