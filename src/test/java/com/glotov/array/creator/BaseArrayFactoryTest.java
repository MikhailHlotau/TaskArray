package com.glotov.array.creator;


import com.glotov.array.entity.BaseArray;
import com.glotov.array.exception.CustomException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

class BaseArrayFactoryTest {

    @Test
    @DisplayName("Test createBaseArray() method with valid input")
    void testCreateBaseArrayWithValidInput() throws CustomException {
        int[] array = {1, 2, 3};
        BaseArray baseArray = BaseArrayFactory.createBaseArray(array);
        Assertions.assertArrayEquals(array, baseArray.getArray());
    }

    @Test
    @DisplayName("Test createBaseArray() method with null input")
    void testCreateBaseArrayWithNullInput() {
        Assertions.assertThrows(CustomException.class, () -> BaseArrayFactory.createBaseArray(null));
    }

    @Test
    @DisplayName("Test createBaseArrays() method with valid input")
    void testCreateBaseArraysWithValidInput() throws CustomException {
        List<int[]> arraysList = new ArrayList<>();
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};
        int[] array3 = {7, 8, 9};
        arraysList.addAll(Arrays.asList(array1, array2, array3));
        List<BaseArray> baseArrays = BaseArrayFactory.createBaseArrays(arraysList);
        Assertions.assertEquals(arraysList.size(), baseArrays.size());
        for (int i = 0; i < arraysList.size(); i++) {
            Assertions.assertArrayEquals(arraysList.get(i), baseArrays.get(i).getArray());
        }
    }

    @Test
    @DisplayName("Test create() method")
    void testCreate() {
        int[] array = {1, 2, 3};
        Supplier<BaseArray> supplier = BaseArrayFactory.create(array);
        BaseArray baseArray = supplier.get();
        Assertions.assertArrayEquals(array, baseArray.getArray());
    }
}
