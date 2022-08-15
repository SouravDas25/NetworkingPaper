package com.github.algo.hashing;

import java.util.List;
import java.util.Optional;

public class TreeHashNode<K, V> implements HashingNode<K, V> {

    @Override
    public boolean put(EntryNode<K, V> node) {
        return false;
    }

    @Override
    public boolean put(K key, V value) {
        return false;
    }

    @Override
    public Optional<EntryNode<K, V>> find(K key) {
        return Optional.empty();
    }

    @Override
    public Optional<V> remove(K key) {
        return Optional.empty();
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public List<EntryNode<K, V>> getAllEntries() {
        return null;
    }

    @Override
    public Optional<V> get(K key) {
        return Optional.empty();
    }
}
