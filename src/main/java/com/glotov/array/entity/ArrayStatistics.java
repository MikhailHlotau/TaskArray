package com.glotov.array.entity;

import com.glotov.array.service.impl.ArrayCalculationImpl;

public class ArrayStatistics {

    ArrayCalculationImpl arrayCalculation = new ArrayCalculationImpl();

    private double averageValue;
    private int sum;
    private int maxValue;
    private int minValue;
    private int count;

    public ArrayStatistics(BaseArray array) {
        this.averageValue = arrayCalculation.getAverage(array);
        this.sum = arrayCalculation.getSum(array);
        this.maxValue = arrayCalculation.getMax(array);
        this.minValue = arrayCalculation.getMin(array);
        this.count = array.getSize();
    }


    @Override
    public String toString() {
        return "ArrayStatistics{" +
                "averageValue=" + averageValue +
                ", sum=" + sum +
                ", maxValue=" + maxValue +
                ", minValue=" + minValue +
                ", count=" + count +
                '}';
    }
}
