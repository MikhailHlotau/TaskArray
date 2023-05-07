package com.glotov.array.entity;

import static org.junit.jupiter.api.Assertions.*;

import com.glotov.array.exception.CustomException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseArrayTest {
    private int[] elements;
    private BaseArray baseArray;

    @BeforeEach
    public void setup() throws CustomException {
        elements = new int[]{1, 2, 3};
        baseArray = new BaseArray(elements);
    }

    @Test
    public void testGetId() {
        assertEquals(1, baseArray.getId());
    }

    @Test
    public void testGetElements() {
        assertArrayEquals(elements, baseArray.getArray());
    }

    @Test
    public void testSetElements() throws CustomException {
        int[] newElements = new int[]{4, 5, 6};
        baseArray.setArray(newElements);
        assertArrayEquals(newElements, baseArray.getArray());
    }


    @Test
    public void testGetSize() {
        assertEquals(3, baseArray.getSize());
    }
}

