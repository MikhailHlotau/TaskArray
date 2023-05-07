package com.glotov.array.service.impl;

import com.glotov.array.entity.BaseArray;
import com.glotov.array.repository.ArrayRepository;
import com.glotov.array.service.ArraySearch;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ArraySearchImpl implements ArraySearch<BaseArray> {

    public ArrayRepository repository;

    public ArraySearchImpl(ArrayRepository repository) {
        this.repository = repository;
    }

    @Override
    public BaseArray findById(int id) {
        for (BaseArray array : repository.getArrayList()) {
            if (array.getId() == id) {
                return array;
            }
        }
        return null;
    }

    @Override
    public List<BaseArray> findBySum(int sum) {
        return repository.getArrayList().stream()
                .filter(a -> new ArrayCalculationImpl(a).getSum() == sum)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseArray> findByAvg(int avg) {
        return repository.getArrayList().stream()
                .filter(a -> new ArrayCalculationImpl(a).getAverage() == avg)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseArray> findByMax(int max) {
        return repository.getArrayList().stream()
                .filter(a -> new ArrayCalculationImpl(a).getMax() == max)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseArray> findByMin(int min) {
        return repository.getArrayList().stream()
                .filter(a -> new ArrayCalculationImpl(a).getMin() == min)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseArray> findByCount(int count) {
        return repository.getArrayList().stream()
                .filter(a -> a.getSize() == count)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseArray> findBySumMore(int sum) {
        return repository.getArrayList().stream()
                .filter(a -> new ArrayCalculationImpl(a).getSum() > sum)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseArray> findByAvgMore(int avg) {
        return repository.getArrayList().stream()
                .filter(a -> new ArrayCalculationImpl(a).getAverage() > avg)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseArray> findByMaxMore(int max) {
        return repository.getArrayList().stream()
                .filter(a -> new ArrayCalculationImpl(a).getMax() > max)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseArray> findByMinMore(int min) {
        return repository.getArrayList().stream()
                .filter(a -> new ArrayCalculationImpl(a).getMin() > min)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseArray> findByCountMore(int count) {
        return repository.getArrayList().stream()
                .filter(a -> a.getSize() > count)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseArray> findBySumLess(int sum) {
        return repository.getArrayList().stream()
                .filter(a -> new ArrayCalculationImpl(a).getSum() < sum)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseArray> findByAvgLess(int avg) {
        return repository.getArrayList().stream()
                .filter(a -> new ArrayCalculationImpl(a).getAverage() < avg)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseArray> findByMaxLess(int max) {
        return repository.getArrayList().stream()
                .filter(a -> new ArrayCalculationImpl(a).getMax() < max)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseArray> findByMinLess(int min) {
        return repository.getArrayList().stream()
                .filter(a -> new ArrayCalculationImpl(a).getMin() < min)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseArray> findByCountLess(int count) {
        return repository.getArrayList().stream()
                .filter(a -> a.getSize() < count)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArraySearchImpl search = (ArraySearchImpl) o;
        return Objects.equals(repository, search.repository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(repository);
    }

    @Override
    public String toString() {
        return "ArraySearchImpl{" +
                "arrayRepository=" + repository +
                '}';
    }
}
