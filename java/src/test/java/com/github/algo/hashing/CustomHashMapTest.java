package com.github.algo.hashing;

import org.junit.jupiter.api.Test;

import java.util.Optional;

class CustomHashMapTest {

    @Test
    void hashMap() {
        CustomHashMap<String, Integer> hashMap = new CustomHashMap<>();
        hashMap.put("Apple", 1);
        hashMap.put("Ball", 2);

        assert hashMap.size() == 2;
        assert hashMap.get("Apple").isPresent();
        assert hashMap.get("Apple").get() == 1;


        hashMap.put("Apple", 3);
        hashMap.remove("PPP");

        assert hashMap.size() == 2;
        assert hashMap.get("Apple").isPresent();
        assert hashMap.get("Apple").get() == 3;

        Optional<Integer> value = hashMap.remove("Apple");

        assert hashMap.size() == 1;
        assert value.isPresent();
        assert value.get() == 3;


        System.out.println(hashMap);
        System.out.println(hashMap.size());

    }
}