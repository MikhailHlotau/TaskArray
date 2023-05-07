package com.glotov.array.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseArrayTest {
    private int[] elements;
    private BaseArray baseArray;

    @BeforeEach
    public void setup() {
        elements = new int[]{1, 2, 3};
        baseArray = new BaseArray(elements);
    }

    @Test
    public void testGetId() {
        assertEquals(1, baseArray.getId());
    }

    @Test
    public void testGetElements() {
        assertArrayEquals(elements, baseArray.getElements());
    }

    @Test
    public void testSetElements() {
        int[] newElements = new int[]{4, 5, 6};
        baseArray.setElements(newElements);
        assertArrayEquals(newElements, baseArray.getElements());
    }

    @Test
    public void testSetElementsNull() {
        int[] expectedElements = new int[]{0};
        baseArray.setElements(null);
        assertArrayEquals(expectedElements, baseArray.getElements());
    }

    @Test
    public void testSetElementsEmpty() {
        int[] expectedElements = new int[]{0};
        baseArray.setElements(new int[]{});
        assertArrayEquals(expectedElements, baseArray.getElements());
    }

    @Test
    public void testGetSize() {
        assertEquals(3, baseArray.getSize());
    }
}

