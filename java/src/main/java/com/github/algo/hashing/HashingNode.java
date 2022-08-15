package com.github.algo.hashing;

import java.util.List;
import java.util.Optional;

public interface HashingNode<K, V> {

    boolean put(EntryNode<K, V> node);

    boolean put(K key, V value);

    Optional<EntryNode<K, V>> find(K key);

    Optional<V> remove(K key);

    boolean contains(K key);

    List<EntryNode<K, V>> getAllEntries();

    Optional<V> get(K key);
}
