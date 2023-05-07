package com.glotov.array.creator;

import com.glotov.array.entity.BaseArray;
import com.glotov.array.exception.CustomException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BaseArrayFactory {
    public static BaseArray createBaseArray(int[] array) throws CustomException {
        if(array == null) {
            throw new CustomException("msg");
        }
        BaseArray newArray = new BaseArray(array);
        return newArray;
    }

    public static List<BaseArray> createBaseArrays(List<int[]> arraysList) {
        List<BaseArray> newArrays = new ArrayList<>();
        for (int[] array : arraysList) {
            BaseArray baseArray = new BaseArray(array);
            baseArray.setElements(array);
            newArrays.add(baseArray);
        }
        return newArrays;
    }

    public static Supplier<BaseArray> create(int[] array) {
        return () -> new BaseArray(array);
    }

}
