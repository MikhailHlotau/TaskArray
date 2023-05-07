package com.glotov.array.creator;

import com.glotov.array.entity.BaseArray;
import com.glotov.array.exception.CustomException;
import com.glotov.array.repository.ArrayRepository;

import java.util.ArrayList;
import java.util.List;

public class RepositoryCreator {
    public static ArrayRepository createFromListObject(List<BaseArray> arraysList) throws CustomException {
        if (arraysList == null) {
            throw new CustomException("Arrays list is null");
        }
        return new ArrayRepository(arraysList);
    }

    public static ArrayRepository createFromListArray(List<int[]> arraysList) throws CustomException {
        if (arraysList == null) {
            throw new CustomException("Arrays list is null");
        }

        List<BaseArray> baseArraysList = new ArrayList<>();
        for (int[] elements : arraysList) {
            if (elements == null) {
                throw new CustomException("Array is null");
            }
            BaseArray array = new BaseArray(elements);
            baseArraysList.add(array);
        }
        return new ArrayRepository(baseArraysList);
    }
}

