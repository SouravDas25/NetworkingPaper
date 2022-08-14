package com.github.algo.commons;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class NestedIteratorTest {

    private NestedInteger convert(JsonElement jsonElement) {
        if (jsonElement.isJsonPrimitive()) {
            return new NestedInteger(jsonElement.getAsInt());
        } else {
            JsonArray objects = jsonElement.getAsJsonArray();
            List<NestedInteger> list = new LinkedList<>();
            for (int i = 0; i < objects.size(); i++) {
                JsonElement obj = objects.get(i);
                list.add(convert(obj));
            }
            return new NestedInteger(list);
        }
    }

    @Test
    void next() {
        Gson gson = new Gson();
        JsonElement jsonElement = gson.fromJson("[1,2,3,[4,5],6,7]", JsonElement.class);
        NestedInteger converted = convert(jsonElement);
        NestedIterator nestedIterator = new NestedIterator(converted.getList());
        while (nestedIterator.hasNext()) {
            System.out.print(nestedIterator.next() + ",");
        }
    }
}