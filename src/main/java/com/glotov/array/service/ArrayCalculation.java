package com.glotov.array.service;
import com.glotov.array.exception.CustomException;

public interface ArrayCalculation<T> {
    double getAverage(T t);

    int getSum(T t);

    int getMax(T t);

    int getMin(T t);

    void replaceElementsIf(T t, int oldValue, int newValue) throws CustomException;

    int calculatePositiveCount(T t);

    int calculateNegativeCount(T t);

    void bubbleSort(T t);

    void selectionSort(T t);

    void insertionSort(T t);
}
