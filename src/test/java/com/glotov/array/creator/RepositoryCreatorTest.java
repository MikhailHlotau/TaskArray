package com.glotov.array.creator;
import com.glotov.array.entity.BaseArray;
import com.glotov.array.exception.CustomException;
import com.glotov.array.repository.ArrayRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RepositoryCreatorTest {

    @Test
    void testCreateFromListObject() throws CustomException {
        List<BaseArray> arraysList = new ArrayList<>();
        arraysList.add(new BaseArray(new int[]{1, 2, 3}));
        arraysList.add(new BaseArray(new int[]{4, 5, 6}));
        ArrayRepository repository = RepositoryCreator.createFromListObject(arraysList);
        Assertions.assertEquals(arraysList, repository.get());
    }

    @Test
    void testCreateFromListObject_NullList() {
        Assertions.assertThrows(CustomException.class, () -> {
            RepositoryCreator.createFromListObject(null);
        });
    }

    @Test
    void testCreateFromListArray() throws CustomException {
        List<int[]> arraysList = new ArrayList<>();
        arraysList.add(new int[]{1, 2, 3});
        arraysList.add(new int[]{4, 5, 6});
        ArrayRepository repository = RepositoryCreator.createFromListArray(arraysList);
        List<BaseArray> expected = new ArrayList<>();
        expected.add(new BaseArray(4,new int[]{1, 2, 3}));
        expected.add(new BaseArray(5,new int[]{4, 5, 6}));

        Assertions.assertEquals(expected, repository.get());
    }

    @Test
    void testCreateFromListArray_NullList() {
        Assertions.assertThrows(CustomException.class, () -> {
            RepositoryCreator.createFromListArray(null);
        });
    }

    @Test
    void testCreateFromListArray_NullArray() {
        List<int[]> arraysList = new ArrayList<>();
        arraysList.add(new int[]{1, 2, 3});
        arraysList.add(null);

        Assertions.assertThrows(CustomException.class, () -> {
            RepositoryCreator.createFromListArray(arraysList);
        });
    }
}

