package com.glotov.array.repository;

import com.glotov.array.entity.BaseArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayRepositoryTest {

    private ArrayRepository arrayRepository;
    private BaseArray baseArray1;
    private BaseArray baseArray2;
    private BaseArray baseArray3;

    @BeforeEach
    void setUp() {
        arrayRepository = new ArrayRepository();

        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};
        int[] arr3 = {7, 8, 9};

        baseArray1 = new BaseArray(arr1);
        baseArray2 = new BaseArray(arr2);
        baseArray3 = new BaseArray(arr3);
    }

    @Test
    void testAddArray() {
        arrayRepository.addArray(baseArray1);
        assertTrue(arrayRepository.contains(baseArray1));
    }

    @Test
    void testRemoveArray() {
        arrayRepository.addArray(baseArray1);
        arrayRepository.removeArray(baseArray1);
        assertFalse(arrayRepository.contains(baseArray1));
    }

    @Test
    void testGetArrays() {
        arrayRepository.addArray(baseArray1);
        arrayRepository.addArray(baseArray2);
        arrayRepository.addArray(baseArray3);
        List<BaseArray> expected = new ArrayList<>();
        expected.add(baseArray1);
        expected.add(baseArray2);
        expected.add(baseArray3);
        assertEquals(expected, arrayRepository.getArrays());
    }

    @Test
    void testContains() {
        arrayRepository.addArray(baseArray1);
        assertTrue(arrayRepository.contains(baseArray1));
        assertFalse(arrayRepository.contains(baseArray2));
        assertFalse(arrayRepository.contains(baseArray3));
    }
}
