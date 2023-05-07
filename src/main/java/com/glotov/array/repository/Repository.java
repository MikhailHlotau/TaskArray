package com.glotov.array.repository;

import com.glotov.array.entity.BaseArray;
import com.glotov.array.exception.CustomException;

import java.util.List;

public interface Repository<T> {

    void add(T t) throws CustomException;

    void remove(T t) throws CustomException;

    boolean contains(T t) throws CustomException;

    void sortById();

    void sortByFirstElement();

    void sortByNumberOfElements();

    void sortBySum();

    void sortByAverage();

    void sortByMax();

    void sortByMin();

    T findById(int id);

    List<T> findBySum(int sum);

    List<T> findByAvg(int avg);

    List<T> findByMax(int max);

    List<T> findByMin(int min);

    List<T> findByCount(int count);

    List<T> findBySumMore(int sum);

    List<T> findByAvgMore(int avg);

    List<T> findByMaxMore(int max);

    List<T> findByMinMore(int min);

    List<T> findByCountMore(int count);

    List<T> findBySumLess(int sum);

    List<T> findByAvgLess(int avg);

    List<T> findByMaxLess(int max);

    List<T> findByMinLess(int min);

    List<T> findByCountLess(int count);
}
