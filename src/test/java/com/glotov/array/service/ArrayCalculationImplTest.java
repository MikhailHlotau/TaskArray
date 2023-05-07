package com.glotov.array.service;

import com.glotov.array.entity.BaseArray;
import com.glotov.array.service.impl.ArrayCalculationImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayCalculationImplTest {

    @Test
    void testGetAverage() {
        BaseArray array = new BaseArray(new int[] {1, 2, 3, 4, 5});
        ArrayCalculationImpl calculation = new ArrayCalculationImpl(array);
        double expected = 3.0;
        double actual = calculation.getAverage();
        Assertions.assertEquals(expected, actual, 0.001);
    }

    @Test
    void testGetSum() {
        BaseArray array = new BaseArray(new int[] {1, 2, 3, 4, 5});
        ArrayCalculationImpl calculation = new ArrayCalculationImpl(array);
        int expected = 15;
        int actual = calculation.getSum();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetMax() {
        BaseArray array = new BaseArray(new int[] {1, 2, 3, 4, 5});
        ArrayCalculationImpl calculation = new ArrayCalculationImpl(array);
        int expected = 5;
        int actual = calculation.getMax();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetMin() {
        BaseArray array = new BaseArray(new int[] {1, 2, 3, 4, 5});
        ArrayCalculationImpl calculation = new ArrayCalculationImpl(array);
        int expected = 1;
        int actual = calculation.getMin();
        Assertions.assertEquals(expected, actual);
    }
}
