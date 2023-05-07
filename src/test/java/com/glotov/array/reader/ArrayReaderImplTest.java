package com.glotov.array.reader;

import com.glotov.array.exception.CustomException;
import com.glotov.array.reader.impl.ArrayReaderImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayReaderImplTest {

    private final ArrayReaderImpl reader = new ArrayReaderImpl();

    @Test
    void testReadArrayAll_existingFile_returnsArrayList() throws CustomException {
        String filename = "data/arrays.txt";
        ArrayList<int[]> expected = new ArrayList<>();
        expected.add(new int[]{11, 12, 13, 14, 15, 16});
        expected.add(new int[]{8, 9, 10, 11, 12});
        expected.add(new int[]{1, 2, 3});
        expected.add(new int[]{4, 5, 6, 7});
        ArrayList<int[]> actual = reader.readArrayAll(filename);
        assertEquals(expected, actual);
    }

    @Test
    void testReadArrayAll_nonExistingFile_throwsException() {
        String filename = "data/nonExistingFile.txt";
        assertThrows(CustomException.class, () -> reader.readArrayAll(filename));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayReaderImplTest that = (ArrayReaderImplTest) o;
        return Objects.equals(reader, that.reader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reader);
    }

    @Override
    public String toString() {
        return "ArrayReaderImplTest{" +
                "reader=" + reader +
                '}';
    }
}


