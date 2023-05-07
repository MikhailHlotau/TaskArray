package com.glotov.array.service.impl;

import com.glotov.array.entity.BaseArray;
import com.glotov.array.exception.CustomException;
import com.glotov.array.service.ArrayCalculation;

public class ArrayCalculationImpl implements ArrayCalculation <BaseArray> {

    public ArrayCalculationImpl() {
    }

    @Override
    public double getAverage(BaseArray array) {
        double sum = 0;
        for (int i = 0; i < array.getArray().length; i++) {
            sum += array.getArray()[i];
        }
        return sum / array.getArray().length;
    }

    @Override
    public int getSum(BaseArray array) {
        int sum = 0;
        for (int i = 0; i < array.getArray().length; i++) {
            sum += array.getArray()[i];
        }
        return sum;
    }

    @Override
    public int getMax(BaseArray array) {
        int max = array.getArray()[0];
        for (int i = 1; i < array.getArray().length; i++) {
            if (array.getArray()[i] > max) {
                max = array.getArray()[i];
            }
        }
        return max;
    }

    @Override
    public int getMin(BaseArray array) {
        int min = array.getArray()[0];
        for (int i = 1; i < array.getArray().length; i++) {
            if (array.getArray()[i] < min) {
                min = array.getArray()[i];
            }
        }
        return min;
    }
    @Override
    public void replaceElementsIf(BaseArray baseArray, int oldValue, int newValue) throws CustomException {
        int[] array = baseArray.getArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == oldValue) {
                array[i] = newValue;
            }
        }
        baseArray.setArray(array);
    }
    @Override
    public int calculatePositiveCount(BaseArray baseArray) {
        int[] array = baseArray.getArray();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                count++;
            }
        }
        return count;
    }
    @Override
    public int calculateNegativeCount(BaseArray baseArray) {
        int[] array = baseArray.getArray();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                count++;
            }
        }
        return count;
    }

    // Сортировка пузырьком
    @Override
    public void bubbleSort(BaseArray array) {
        int n = array.getSize();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array.getArray()[j] > array.getArray()[j + 1]) {
                    // меняем местами элементы
                    int temp = array.getArray()[j];
                    array.getArray()[j] = array.getArray()[j + 1];
                    array.getArray()[j + 1] = temp;
                }
            }
        }
    }

    // Сортировка выбором
    @Override
    public void selectionSort(BaseArray array) {
        int n = array.getSize();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array.getArray()[j] < array.getArray()[minIndex]) {
                    minIndex = j;
                }
            }
            // меняем местами элементы
            int temp = array.getArray()[i];
            array.getArray()[i] = array.getArray()[minIndex];
            array.getArray()[minIndex] = temp;
        }
    }

    // Сортировка вставками
    @Override
    public void insertionSort(BaseArray array) {
        int n = array.getSize();
        for (int i = 1; i < n; ++i) {
            int key = array.getArray()[i];
            int j = i - 1;
            while (j >= 0 && array.getArray()[j] > key) {
                array.getArray()[j + 1] = array.getArray()[j];
                j = j - 1;
            }
            array.getArray()[j + 1] = key;
        }
    }

    @Override
    public String toString() {
        return "ArrayCalculationImpl{}";
    }
}


