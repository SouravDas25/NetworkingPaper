package com.github.algo.cache;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCache<K, V> {

    private int capacity;
    private Map<K, V> maps = new HashMap<>();
    private Set<K> queue = new LinkedHashSet<>();


    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    private void moveKeyToLast(K key) {
        queue.remove(key);
        queue.add(key);
    }

    public V get(K key) {
        if (maps.containsKey(key)) {
            moveKeyToLast(key);
            return maps.get(key);
        }
        return null;
    }

    public void put(K key, V value) {
        if (maps.containsKey(key)) {
            moveKeyToLast(key);
            maps.put(key, value);
        } else {
            if (maps.size() >= capacity) {
                K leastRecentKey = queue.iterator().next();
                queue.remove(leastRecentKey);
                maps.remove(leastRecentKey);
            }
            maps.put(key, value);
            queue.add(key);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LRUCache{");
        sb.append("capacity=").append(capacity);
        sb.append(", maps=").append(maps);
        sb.append(", queue=").append(queue);
        sb.append('}');
        return sb.toString();
    }
}
