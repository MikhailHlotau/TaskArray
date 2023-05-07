package com.glotov.array.service;

import java.util.List;

public interface ArraySearch <T> {

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
