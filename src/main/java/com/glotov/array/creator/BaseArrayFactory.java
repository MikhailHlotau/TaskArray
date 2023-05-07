package com.glotov.array.creator;

import com.glotov.array.entity.BaseArray;
import com.glotov.array.exception.CustomException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BaseArrayFactory {

    public static BaseArray createBaseArray(int[] array) throws CustomException {
        if (array == null) {
            throw new CustomException("Arrays is null");
        }
        BaseArray baseArray = new BaseArray(array);
        return baseArray;
    }

    public static List<BaseArray> createBaseArrays(List<int[]> arrays) throws CustomException {
        if (arrays == null) {
            throw new CustomException("Arrays is null");
        }
        List<BaseArray> newBaseArrays = new ArrayList<>();
        for (int[] array : arrays) {
            if (array == null) {
                throw new CustomException("Array is null");
            }
            BaseArray baseArray = new BaseArray(array);
            baseArray.setArray(array);
            newBaseArrays.add(baseArray);
        }
        return newBaseArrays;
    }

    public static Supplier<BaseArray> create(int[] array) {
        return () -> {
            try {
                return new BaseArray(array);
            } catch (CustomException e) {
                throw new RuntimeException(e);
            }
        };
    }
}

