package com.glotov.array.repository;

import com.glotov.array.entity.BaseArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArrayRepository {
    private final List<BaseArray> arrayList;


    public ArrayRepository(List<BaseArray> arrayList) {
        this.arrayList = arrayList;
    }

    public ArrayRepository() {
        this.arrayList = new ArrayList<>();
    }


    public List<BaseArray> getArrayList() {
        return arrayList;
    }

    public void addArray(BaseArray array) {
        arrayList.add(array);
    }

    public void removeArray(BaseArray array) {
        arrayList.remove(array);
    }

    public List<BaseArray> getArrays() {
        return arrayList;
    }

    public boolean contains(BaseArray array) {
        return arrayList.contains(array);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayRepository that = (ArrayRepository) o;
        return Objects.equals(arrayList, that.arrayList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arrayList);
    }

    @Override
    public String toString() {
        return "ArrayRepository{" +
                "arrayList=" + arrayList +
                '}';
    }
}


