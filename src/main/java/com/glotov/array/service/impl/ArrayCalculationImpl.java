package com.glotov.array.service.impl;

import com.glotov.array.entity.BaseArray;
import com.glotov.array.service.ArrayCalculation;

public class ArrayCalculationImpl implements ArrayCalculation <BaseArray> {

    BaseArray array = new BaseArray();

    public ArrayCalculationImpl(BaseArray array) {
        this.array = array;
    }


    @Override
    public double getAverage() {
        double sum = 0;
        for (int i = 0; i < array.getElements().length; i++) {
            sum += array.getElements()[i];
        }
        return sum / array.getElements().length;
    }

    @Override
    public int getSum() {
        int sum = 0;
        for (int i = 0; i < array.getElements().length; i++) {
            sum += array.getElements()[i];
        }
        return sum;
    }

    @Override
    public int getMax() {
        int max = array.getElements()[0];
        for (int i = 1; i < array.getElements().length; i++) {
            if (array.getElements()[i] > max) {
                max = array.getElements()[i];
            }
        }
        return max;
    }

    @Override
    public int getMin() {
        int min = array.getElements()[0];
        for (int i = 1; i < array.getElements().length; i++) {
            if (array.getElements()[i] < min) {
                min = array.getElements()[i];
            }
        }
        return min;
    }

    @Override
    public String toString() {
        return "ArrayCalculationImpl{" +
                "array=" + array +
                '}';
    }
}


