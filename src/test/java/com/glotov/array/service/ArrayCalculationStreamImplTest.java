package com.glotov.array.service;

import com.glotov.array.entity.BaseArray;
import com.glotov.array.exception.CustomException;
import com.glotov.array.service.impl.ArrayCalculationStreamImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayCalculationStreamImplTest {

    private ArrayCalculationStream<BaseArray> arrayCalculationStream;

    @BeforeEach
    public void setUp() {
        arrayCalculationStream = new ArrayCalculationStreamImpl();
    }

    @Test
    public void testGetAverageStream() throws CustomException {
        BaseArray array = new BaseArray(new int[]{1, 2, 3, 4, 5});
        double average = arrayCalculationStream.getAverageStream(array);
        Assertions.assertEquals(3.0, average);
    }

    @Test
    public void testGetSumStream() throws CustomException {
        BaseArray array = new BaseArray(new int[]{1, 2, 3, 4, 5});
        int sum = arrayCalculationStream.getSumStream(array);
        Assertions.assertEquals(15, sum);
    }

    @Test
    public void testGetMaxStream() throws CustomException {
        BaseArray array = new BaseArray(new int[]{1, 2, 3, 4, 5});
        int max = arrayCalculationStream.getMaxStream(array);
        Assertions.assertEquals(5, max);
    }

    @Test
    public void testGetMinStream() throws CustomException {
        BaseArray array = new BaseArray(new int[]{1, 2, 3, 4, 5});
        int min = arrayCalculationStream.getMinStream(array);
        Assertions.assertEquals(1, min);
    }

    @Test
    public void testReplaceElementsIfStream() throws CustomException {
        BaseArray array = new BaseArray(new int[]{1, 2, 3, 4, 5});
        arrayCalculationStream.replaceElementsIfStream(array, 2, 10);
        int[] expectedArray = {1, 10, 3, 4, 5};
        Assertions.assertArrayEquals(expectedArray, array.getArray());
    }

    @Test
    public void testCalculatePositiveCountStream() throws CustomException {
        BaseArray array = new BaseArray(new int[]{-1, -2, 0, 3, 4, 5});
        int count = arrayCalculationStream.calculatePositiveCountStream(array);
        Assertions.assertEquals(3, count);
    }

    @Test
    public void testCalculateNegativeCountStream() throws CustomException {
        BaseArray array = new BaseArray(new int[]{-1, -2, 0, 3, 4, 5});
        int count = arrayCalculationStream.calculateNegativeCountStream(array);
        Assertions.assertEquals(2, count);
    }
}

