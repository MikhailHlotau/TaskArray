package com.glotov.array.repository;

import com.glotov.array.entity.BaseArray;
import com.glotov.array.exception.CustomException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayRepositoryTest {

    private ArrayRepository arrayRepo;
    private BaseArray[] baseArrays;

    @BeforeEach
    void setUp() throws CustomException {
        baseArrays = new BaseArray[3];
        baseArrays[0] = new BaseArray(0, new int[] {1, 2, 3});
        baseArrays[1] = new BaseArray(1, new int[] {4, 3, 2, 1});
        baseArrays[2] = new BaseArray(2, new int[] {-1, 5, 10, 4});

        List<BaseArray> baseArrayList = new ArrayList<>(Arrays.asList(baseArrays));
        arrayRepo = new ArrayRepository(baseArrayList);
    }

    @Test
    void testAdd() throws CustomException {
        BaseArray newArray = new BaseArray(3, new int[] {1, 1, 1});
        arrayRepo.add(newArray);
        assertTrue(arrayRepo.contains(newArray));
    }

    @Test
    void testRemove() throws CustomException {
        BaseArray arrayToRemove = baseArrays[0];
        arrayRepo.remove(arrayToRemove);
        assertFalse(arrayRepo.contains(arrayToRemove));
    }

    @Test
    void testSortById() {
        arrayRepo.sortById();
        assertEquals(baseArrays[0], arrayRepo.get().get(0));
        assertEquals(baseArrays[1], arrayRepo.get().get(1));
        assertEquals(baseArrays[2], arrayRepo.get().get(2));
    }

    @Test
    void testSortByFirstElement() {
        arrayRepo.sortByFirstElement();
        assertEquals(baseArrays[2], arrayRepo.get().get(0));
        assertEquals(baseArrays[0], arrayRepo.get().get(1));
        assertEquals(baseArrays[1], arrayRepo.get().get(2));
    }

    @Test
    void testSortByNumberOfElements() {
        arrayRepo.sortByNumberOfElements();
        assertEquals(baseArrays[0], arrayRepo.get().get(0));
        assertEquals(baseArrays[1], arrayRepo.get().get(1));
        assertEquals(baseArrays[2], arrayRepo.get().get(2));
    }

    @Test
    void testSortBySum() {
        arrayRepo.sortBySum();
        assertEquals(baseArrays[0], arrayRepo.get().get(0));
        assertEquals(baseArrays[1], arrayRepo.get().get(1));
        assertEquals(baseArrays[2], arrayRepo.get().get(2));
    }

    @Test
    void testSortByAverage() {
        arrayRepo.sortByAverage();
        assertEquals(baseArrays[0], arrayRepo.get().get(0));
        assertEquals(baseArrays[1], arrayRepo.get().get(1));
        assertEquals(baseArrays[2], arrayRepo.get().get(2));
    }

    @Test
    void testSortByMax() {
        arrayRepo.sortByMax();
        assertEquals(baseArrays[0], arrayRepo.get().get(0));
        assertEquals(baseArrays[1], arrayRepo.get().get(1));
        assertEquals(baseArrays[2], arrayRepo.get().get(2));
    }
}
