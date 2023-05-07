package com.glotov.array.entity;

public class ArrayStatistics {
    private double averageValue;
    private int sum;
    private int maxValue;
    private int minValue;
    private int count;

    public ArrayStatistics(BaseArray array) {
    }

    public ArrayStatistics(double averageValue, int sum, int maxValue, int minValue, int count) {
        this.averageValue = averageValue;
        this.sum = sum;
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.count = count;
    }
}
