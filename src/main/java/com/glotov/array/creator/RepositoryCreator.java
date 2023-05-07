package com.glotov.array.creator;

import com.glotov.array.entity.BaseArray;
import com.glotov.array.repository.ArrayRepository;

import java.util.List;

public class RepositoryCreator {
    public static ArrayRepository createFromListObject(List<BaseArray> baseArrayList) {
        return new ArrayRepository(baseArrayList);
    }

    public static ArrayRepository createFromListArray(List<int[]> arraysList) {
        return null;
    }
}
