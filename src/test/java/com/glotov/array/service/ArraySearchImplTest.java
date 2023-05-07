package com.glotov.array.service;

import com.glotov.array.entity.BaseArray;
import com.glotov.array.repository.ArrayRepository;
import com.glotov.array.service.impl.ArraySearchImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArraySearchImplTest {

    private ArrayRepository repository;
    private ArraySearch<BaseArray> arraySearch;

    @BeforeEach
    public void setUp() {
        BaseArray array1 = new BaseArray(new int[]{1, 2, 3});
        BaseArray array2 = new BaseArray(new int[]{4, 5, 6});
        BaseArray array3 = new BaseArray(new int[]{7, 8, 9});

        repository = new ArrayRepository(new ArrayList<>(Arrays.asList(array1, array2, array3)));
        arraySearch = new ArraySearchImpl(repository);
    }

    @Test
    public void testFindById() {
        BaseArray result = arraySearch.findById(2);
        assertNotNull(result);
        assertEquals(2, result.getId());
        assertArrayEquals(new int[]{4, 5, 6}, result.getElements());
    }

    @Test
    public void testFindBySum() {
        List<BaseArray> result = arraySearch.findBySum(15);
        assertEquals(1, result.size());
        assertArrayEquals(new int[]{1, 2, 3}, result.get(0).getElements());
    }

    @Test
    public void testFindByAvg() {
        List<BaseArray> result = arraySearch.findByAvg(6);
        assertEquals(1, result.size());
        assertArrayEquals(new int[]{4, 5, 6}, result.get(0).getElements());
    }

    @Test
    public void testFindByMax() {
        List<BaseArray> result = arraySearch.findByMax(9);
        assertEquals(1, result.size());
        assertArrayEquals(new int[]{7, 8, 9}, result.get(0).getElements());
    }

    @Test
    public void testFindByMin() {
        List<BaseArray> result = arraySearch.findByMin(1);
        assertEquals(1, result.size());
        assertArrayEquals(new int[]{1, 2, 3}, result.get(0).getElements());
    }
}

