package com.glotov.array.service;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.glotov.array.entity.BaseArray;
import com.glotov.array.repository.ArrayRepository;
import com.glotov.array.service.impl.ArrayCalculationImpl;
import com.glotov.array.service.impl.ArraySortImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArraySortImplTest {

    private ArrayRepository repository;
    private ArraySort arraySort;
    private List<BaseArray> expectedArrayList;

    @BeforeEach
    void setUp() {
        repository = new ArrayRepository();
        BaseArray array1 = new BaseArray(new int[] { 1, 2, 3 });
        BaseArray array2 = new BaseArray(new int[] { 4, 5, 6 });
        BaseArray array3 = new BaseArray(new int[] { 7, 8, 9 });
        BaseArray array4 = new BaseArray(new int[] { 10, 11, 12 });
        repository.addArray(array1);
        repository.addArray(array2);
        repository.addArray(array3);
        repository.addArray(array4);
        arraySort = new ArraySortImpl(repository);
        expectedArrayList = Arrays.asList(array1, array2, array3, array4);
    }

    @Test
    void sortById() {
        Collections.shuffle(expectedArrayList); // перемешиваем массивы, чтобы порядок id был случайным
        arraySort.sortById();
        assertArrayEquals(expectedArrayList.toArray(), repository.getArrayList().toArray());
    }

    @Test
    void sortByFirstElement() {
        Collections.sort(expectedArrayList, (a1, a2) -> a1.getElements()[0] - a2.getElements()[0]);
        arraySort.sortByFirstElement();
        assertArrayEquals(expectedArrayList.toArray(), repository.getArrayList().toArray());
    }

    @Test
    void sortByNumberOfElements() {
        Collections.sort(expectedArrayList, (a1, a2) -> a1.getSize() - a2.getSize());
        arraySort.sortByNumberOfElements();
        assertArrayEquals(expectedArrayList.toArray(), repository.getArrayList().toArray());
    }

    @Test
    void sortBySum() {
        Collections.sort(expectedArrayList, (a1, a2) -> new ArrayCalculationImpl(a1).getSum() - new ArrayCalculationImpl(a2).getSum());
        arraySort.sortBySum();
        assertArrayEquals(expectedArrayList.toArray(), repository.getArrayList().toArray());
    }

    @Test
    void sortByAverage() {
        Collections.sort(expectedArrayList, (a1, a2) -> Double.compare(new ArrayCalculationImpl(a1).getAverage(), new ArrayCalculationImpl(a2).getAverage()));
        arraySort.sortByAverage();
        assertArrayEquals(expectedArrayList.toArray(), repository.getArrayList().toArray());
    }

    @Test
    void sortByMax() {
        Collections.sort(expectedArrayList, (a1, a2) -> new ArrayCalculationImpl(a1).getMax() - new ArrayCalculationImpl(a2).getMax());
        arraySort.sortByMax();
        assertArrayEquals(expectedArrayList.toArray(), repository.getArrayList().toArray());
    }

    @Test
    void sortByMin() {
        Collections.sort(expectedArrayList, (a1, a2) -> new ArrayCalculationImpl(a1).getMin() - new ArrayCalculationImpl(a2).getMin());
        arraySort.sortByMin();
        assertArrayEquals(expectedArrayList.toArray(), repository.getArrayList().toArray());
    }

}
