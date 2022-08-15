package com.github.algo.hashing;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class LinkedHashingNode<K, V> implements HashingNode<K, V> {
    List<EntryNode<K, V>> items = new LinkedList<>();

    public boolean put(EntryNode<K, V> node) {
        Optional<EntryNode<K, V>> pn = find(node.getKey());
        if (pn.isPresent()) {
            pn.get().setValue(node.getValue());
        } else {
            items.add(node);
        }
        return pn.isPresent();
    }

    public boolean put(K key, V value) {
        Optional<EntryNode<K, V>> node = find(key);
        if (node.isPresent()) {
            node.get().setValue(value);
        } else {
            items.add(new EntryNode<>(key, value));
        }
        return node.isPresent();
    }

    public Optional<EntryNode<K, V>> find(K key) {
        for (EntryNode<K, V> node : items) {
            if (node.getKey().equals(key)) {
                return Optional.of(node);
            }
        }
        return Optional.empty();
    }

    public Optional<V> remove(K key) {
        Iterator<EntryNode<K, V>> iterator = items.iterator();
        while (iterator.hasNext()) {
            EntryNode<K, V> node = iterator.next();
            if (node.getKey().equals(key)) {
                iterator.remove();
                return Optional.of(node.getValue());
            }
        }
        return Optional.empty();
    }

    public boolean contains(K key) {
        return find(key).isPresent();
    }

    @Override
    public List<EntryNode<K, V>> getAllEntries() {
        return this.items;
    }

    @Override
    public Optional<V> get(K key) {
        Optional<EntryNode<K, V>> kvEntryNode = find(key);
        return kvEntryNode.map(EntryNode::getValue);
    }

}
