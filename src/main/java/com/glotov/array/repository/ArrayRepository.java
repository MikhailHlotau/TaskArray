package com.glotov.array.repository;

import com.glotov.array.entity.BaseArray;
import com.glotov.array.exception.CustomException;
import com.glotov.array.repository.spec.Specification;
import com.glotov.array.service.impl.ArrayCalculationImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class ArrayRepository implements Repository <BaseArray> {
    private final List<BaseArray> baseArrayList;

    public ArrayRepository(List<BaseArray> baseArrayList) {
        this.baseArrayList = baseArrayList;
    }

    ArrayCalculationImpl arrayCalculation = new ArrayCalculationImpl();


    public List<BaseArray> query(Specification specification) {
        List<BaseArray> results = new ArrayList<>();
        for (BaseArray array : baseArrayList) {
            if (specification.specify(array)) {
                results.add(array);
            }
        }
        return results;
    }


   /* public List<BaseArray> queryStream(Specification specification) {
        List<BaseArray> results =
                baseArrayList.stream().filter(array -> specification.specify(array)).toList();
        return results;
    }

    public List<BaseArray> queryPredicate(Predicate<BaseArray> predicate) {
        List<BaseArray> results =
                baseArrayList.stream().filter(predicate).toList();
        return results;
    }
*/
    public List<BaseArray> get() {
        return baseArrayList;
    }
    @Override
    public void add(BaseArray array) throws CustomException {
        if (array == null) {
            throw new CustomException("Array is null");
        }
        baseArrayList.add(array);
    }

    @Override
    public void remove(BaseArray array) throws CustomException {
        if (array == null) {
            throw new CustomException("Array is null");
        }
        baseArrayList.remove(array);
    }

    @Override
    public boolean contains(BaseArray array) throws CustomException {
        if (array == null) {
            throw new CustomException("Array is null");
        }
        return baseArrayList.contains(array);
    }

    @Override
    public void sortById() {
        baseArrayList.sort(Comparator.comparingInt(BaseArray::getId));
    }

    @Override
    public void sortByFirstElement() {
        baseArrayList.sort(Comparator.comparingInt(a -> a.getArray()[0]));
    }

    @Override
    public void sortByNumberOfElements() {
        baseArrayList.sort(Comparator.comparingInt(BaseArray::getSize));
    }

    @Override
    public void sortBySum() {
        baseArrayList.sort(Comparator.comparingInt(a -> arrayCalculation.getSum(a)));
    }

    @Override
    public void sortByAverage() {
        baseArrayList.sort(Comparator.comparingDouble(a -> arrayCalculation.getAverage(a)));
    }

    @Override
    public void sortByMax() {
        baseArrayList.sort(Comparator.comparingInt(a -> arrayCalculation.getMax(a)));
    }

    @Override
    public void sortByMin() {
        baseArrayList.sort(Comparator.comparingInt(a -> arrayCalculation.getMin(a)));
    }
    @Override
    public BaseArray findById(int id) {
        for (BaseArray array : baseArrayList) {
            if (array.getId() == id) {
                return array;
            }
        }
        return null;
    }

    @Override
    public List<BaseArray> findBySum(int sum) {
        return baseArrayList.stream()
                .filter(a -> arrayCalculation.getSum(a) == sum)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseArray> findByAvg(int avg) {
        return baseArrayList.stream()
                .filter(a -> arrayCalculation.getAverage(a) == avg)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseArray> findByMax(int max) {
        return baseArrayList.stream()
                .filter(a -> arrayCalculation.getMax(a) == max)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseArray> findByMin(int min) {
        return baseArrayList.stream()
                .filter(a -> arrayCalculation.getMin(a) == min)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseArray> findByCount(int count) {
        return baseArrayList.stream()
                .filter(a -> a.getSize() == count)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseArray> findBySumMore(int sum) {
        return baseArrayList.stream()
                .filter(a -> arrayCalculation.getSum(a) > sum)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseArray> findByAvgMore(int avg) {
        return baseArrayList.stream()
                .filter(a -> arrayCalculation.getAverage(a) > avg)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseArray> findByMaxMore(int max) {
        return baseArrayList.stream()
                .filter(a -> arrayCalculation.getMax(a) > max)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseArray> findByMinMore(int min) {
        return baseArrayList.stream()
                .filter(a -> arrayCalculation.getMin(a) > min)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseArray> findByCountMore(int count) {
        return baseArrayList.stream()
                .filter(a -> a.getSize() > count)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseArray> findBySumLess(int sum) {
        return baseArrayList.stream()
                .filter(a -> arrayCalculation.getSum(a) < sum)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseArray> findByAvgLess(int avg) {
        return baseArrayList.stream()
                .filter(a -> arrayCalculation.getAverage(a) < avg)
                .collect(Collectors.toList());
    }
    @Override
    public List<BaseArray> findByMaxLess(int max) {
        return baseArrayList.stream()
                .filter(a -> arrayCalculation.getMax(a) < max)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseArray> findByMinLess(int min) {
        return baseArrayList.stream()
                .filter(a -> arrayCalculation.getMin(a) < min)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseArray> findByCountLess(int count) {
        return baseArrayList.stream()
                .filter(a -> a.getSize() < count)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayRepository that = (ArrayRepository) o;
        return Objects.equals(baseArrayList, that.baseArrayList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseArrayList);
    }

    @Override
    public String toString() {
        return "ArrayRepository{" +
                "arrayList=" + baseArrayList +
                '}';
    }
}


