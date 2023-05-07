package com.glotov.array.service;

import com.glotov.array.entity.BaseArray;
import com.glotov.array.exception.CustomException;
import com.glotov.array.service.impl.ArrayCalculationImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayCalculationImplTest {

    @Test
    void testGetAverage() throws CustomException {
        BaseArray array = new BaseArray(new int[]{1, 2, 3, 4, 5});
        ArrayCalculationImpl calculation = new ArrayCalculationImpl();
        double expected = 3.0;
        double actual = calculation.getAverage(array);
        Assertions.assertEquals(expected, actual, 0.001);
    }

    @Test
    void testGetSum() throws CustomException {
        BaseArray array = new BaseArray(new int[]{1, 2, 3, 4, 5});
        ArrayCalculationImpl calculation = new ArrayCalculationImpl();
        int expected = 15;
        int actual = calculation.getSum(array);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetMax() throws CustomException {
        BaseArray array = new BaseArray(new int[]{1, 2, 3, 4, 5});
        ArrayCalculationImpl calculation = new ArrayCalculationImpl();
        int expected = 5;
        int actual = calculation.getMax(array);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetMin() throws CustomException {
        BaseArray array = new BaseArray(new int[]{1, 2, 3, 4, 5});
        ArrayCalculationImpl calculation = new ArrayCalculationImpl();
        int expected = 1;
        int actual = calculation.getMin(array);
        Assertions.assertEquals(expected, actual);
    }

    void testReplaceElementsIf() throws CustomException {
        BaseArray array = new BaseArray(new int[]{1, 2, 3, 4, 5});
        ArrayCalculationImpl calculation = new ArrayCalculationImpl();
        calculation.replaceElementsIf(array, 3, 0);
        int[] expected = new int[]{1, 2, 0, 4, 5};
        int[] actual = array.getArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testCalculatePositiveCount() throws CustomException {
        BaseArray array = new BaseArray(new int[]{-1, -2, 0, 3, 4, 5});
        ArrayCalculationImpl calculation = new ArrayCalculationImpl();
        int expected = 3;
        int actual = calculation.calculatePositiveCount(array);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testCalculateNegativeCount() throws CustomException {
        BaseArray array = new BaseArray(new int[]{-1, -2, 0, 3, 4, 5});
        ArrayCalculationImpl calculation = new ArrayCalculationImpl();
        int expected = 2;
        int actual = calculation.calculateNegativeCount(array);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testBubbleSort() throws CustomException {
        BaseArray array = new BaseArray(new int[]{5, 4, 3, 2, 1});
        ArrayCalculationImpl calculation = new ArrayCalculationImpl();
        calculation.bubbleSort(array);
        int[] expected = new int[]{1, 2, 3, 4, 5};
        int[] actual = array.getArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testSelectionSort() throws CustomException {
        BaseArray array = new BaseArray(new int[]{5, 4, 3, 2, 1});
        ArrayCalculationImpl calculation = new ArrayCalculationImpl();
        calculation.selectionSort(array);
        int[] expected = new int[]{1, 2, 3, 4, 5};
        int[] actual = array.getArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testInsertionSort() throws CustomException {
        BaseArray array = new BaseArray(new int[]{5, 4, 3, 2, 1});
        ArrayCalculationImpl calculation = new ArrayCalculationImpl();
        calculation.insertionSort(array);
        int[] expected = new int[]{1, 2, 3, 4, 5};
        int[] actual = array.getArray();
        Assertions.assertArrayEquals(expected, actual);
    }
}
