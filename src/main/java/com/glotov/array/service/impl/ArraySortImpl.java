package com.glotov.array.service.impl;

import com.glotov.array.entity.BaseArray;
import com.glotov.array.repository.ArrayRepository;
import com.glotov.array.service.ArraySort;

import java.util.Comparator;

public class ArraySortImpl implements ArraySort {


    public ArrayRepository repository;

    public ArraySortImpl(ArrayRepository repository) {
        this.repository = repository;
    }

    @Override
    public void sortById() {
        repository.getArrayList().sort(Comparator.comparingInt(BaseArray::getId));
    }

    @Override
    public void sortByFirstElement() {
        repository.getArrayList().sort(Comparator.comparingInt(a -> a.getElements()[0]));
    }

    @Override
    public void sortByNumberOfElements() {
        repository.getArrayList().sort(Comparator.comparingInt(BaseArray::getSize));
    }

    @Override
    public void sortBySum() {
        repository.getArrayList().sort(Comparator.comparingInt(a -> new ArrayCalculationImpl(a).getSum()));
    }

    @Override
    public void sortByAverage() {
        repository.getArrayList().sort(Comparator.comparingDouble(a -> new ArrayCalculationImpl(a).getAverage()));
    }

    @Override
    public void sortByMax() {
        repository.getArrayList().sort(Comparator.comparingInt(a -> new ArrayCalculationImpl(a).getMax()));
    }

    @Override
    public void sortByMin() {
        repository.getArrayList().sort(Comparator.comparingInt(a -> new ArrayCalculationImpl(a).getMin()));
    }

}
