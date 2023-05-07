package com.glotov.array.service.impl;

import com.glotov.array.entity.BaseArray;
import com.glotov.array.exception.CustomException;
import com.glotov.array.service.ArrayCalculationStream;

import java.util.Arrays;

public class ArrayCalculationStreamImpl implements ArrayCalculationStream<BaseArray> {

    @Override
    public double getAverageStream(BaseArray array) {
        return Arrays.stream(array.getArray()).average().orElse(0);
    }

    @Override
    public int getSumStream(BaseArray array) {
        return Arrays.stream(array.getArray()).sum();
    }

    @Override
    public int getMaxStream(BaseArray array) {
        return Arrays.stream(array.getArray()).max().orElse(0);
    }

    @Override
    public int getMinStream(BaseArray array) {
        return Arrays.stream(array.getArray()).min().orElse(0);
    }

    @Override
    public void replaceElementsIfStream(BaseArray array, int oldValue, int newValue) throws CustomException {
        int[] newArray = Arrays.stream(array.getArray())
                .map(element -> element == oldValue ? newValue : element)
                .toArray();
        array.setArray(newArray);
    }

    @Override
    public int calculatePositiveCountStream(BaseArray array) {
        return (int) Arrays.stream(array.getArray())
                .filter(element -> element > 0)
                .count();
    }

    @Override
    public int calculateNegativeCountStream(BaseArray array) {
        return (int) Arrays.stream(array.getArray())
                .filter(element -> element < 0)
                .count();
    }
}
