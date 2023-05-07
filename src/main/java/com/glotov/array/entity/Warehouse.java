package com.glotov.array.entity;

import com.glotov.array.exception.CustomException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Warehouse {
    private static final Warehouse instance = new Warehouse();
    private Map<Integer, ArrayStatistics> map = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        return instance;
    }

    public ArrayStatistics put(Integer key, ArrayStatistics value) throws CustomException {
        if (key == null || value == null) {
            throw new CustomException("Invalid key or value");
        }
        return map.put(key, value);
    }

    public ArrayStatistics remove(Integer key) throws CustomException {
        if (key == null) {
            throw new CustomException("Invalid key");
        }
        return map.remove(key);
    }

    public ArrayStatistics replace(Integer key, ArrayStatistics value) throws CustomException {
        if (key == null || value == null) {
            throw new CustomException("Invalid key or value");
        }
        return map.replace(key, value);
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "map=" + map +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warehouse warehouse = (Warehouse) o;
        return Objects.equals(map, warehouse.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(map);
    }
}
