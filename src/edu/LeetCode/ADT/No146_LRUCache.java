package edu.LeetCode.ADT;

import java.util.LinkedHashMap;
import java.util.Map;

public class No146_LRUCache extends LinkedHashMap<String, String> {
    private int capacity;

    public No146_LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public String get(String key) {
        return super.get(key);
    }

    public String put(String key, String value) {
        return super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
        return size() > capacity;
    }
}
