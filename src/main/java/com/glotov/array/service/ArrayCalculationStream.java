package com.glotov.array.service;
import com.glotov.array.exception.CustomException;

public interface ArrayCalculationStream<T> {
    double getAverageStream(T t);

    int getSumStream(T t);

    int getMaxStream(T t);

    int getMinStream(T t);

    void replaceElementsIfStream(T t, int oldValue, int newValue) throws CustomException;

    int calculatePositiveCountStream(T t);

    int calculateNegativeCountStream(T t);
}
