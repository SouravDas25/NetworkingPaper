package com.github.algo.hashing;

import java.util.*;
import java.util.stream.Collectors;


public class CustomHashMap<K, V> {

    private HashingNode<K, V>[] array;
    private int size = 0;
    private int capacity = 2;

    public CustomHashMap() {
        array = new LinkedHashingNode[capacity];
        for (int i = 0; i < array.length; i++) {
            array[i] = new LinkedHashingNode<>();
        }
    }

    private void resize() {
        capacity *= 2;
        HashingNode<K, V>[] oldArray = array;
        this.array = new LinkedHashingNode[capacity];
        for (int i = 0; i < array.length; i++) {
            array[i] = new LinkedHashingNode<>();
        }

        Arrays.stream(oldArray)
                .flatMap(hn -> hn.getAllEntries().stream())
                .forEach(this::rehash);
    }

    private void rehash(EntryNode<K, V> node) {
        int index = indexify(node.getKey());
        array[index].put(node);
    }

    public int size() {
        return size;
    }

    private int indexify(K key) {
        return key.hashCode() % capacity;
    }

    public void put(K key, V value) {
        if (size / (double) capacity > 0.75) {
            resize();
        }
        int index = indexify(key);
        boolean wasPreset = array[index].put(key, value);
        if (!wasPreset) size++;
    }

    public Optional<V> get(K key) {
        int index = indexify(key);
        return array[index].get(key);
    }

    public Optional<V> remove(K key) {
        int index = indexify(key);
        Optional<V> value = array[index].remove(key);
        if (value.isPresent()) {
            size--;
        }
        return value;
    }

    public boolean contains(K key) {
        int index = indexify(key);
        return array[index].contains(key);
    }

    @Override
    public String toString() {
        return "{" + Arrays.stream(array).flatMap(hn -> hn.getAllEntries().stream())
                .map(Objects::toString)
                .collect(Collectors.joining(", ")) + "}";
    }
}
