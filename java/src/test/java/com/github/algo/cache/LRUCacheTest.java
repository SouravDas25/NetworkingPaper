package com.github.algo.cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    @Test
    void cache() {
        LRUCache<String, Integer> lruCache = new LRUCache<>(3);

        lruCache.put("APPLE", 3);
        lruCache.put("BALL", 2);

        System.out.println(lruCache);

        lruCache.put("CAT", 4);
        System.out.println(lruCache);
        lruCache.get("APPLE");
        System.out.println(lruCache);
        lruCache.put("DOG", 1);
        System.out.println(lruCache);

    }
}