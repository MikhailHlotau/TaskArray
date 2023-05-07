package com.glotov.array.reader;

import com.glotov.array.exception.CustomException;
import com.glotov.array.reader.impl.ArrayReaderImpl;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;

public class ArrayReaderImplTest {

    private static final String TEST_FILENAME = "data\\test_arrays.txt";

    @Test
    void testReadArrayAll() throws CustomException {
        ArrayReaderImpl arrayReader = new ArrayReaderImpl();
        ArrayList<int[]> expected = new ArrayList<>();
        expected.add(new int[] {1, 2, 3});
        expected.add(new int[] {4, 5});
        expected.add(new int[] {6, 7, 8, 9});
        ArrayList<int[]> actual = arrayReader.readArrayAll(TEST_FILENAME);
        Assertions.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertArrayEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    void testReadArrayAll_fileNotFound() {
        ArrayReaderImpl arrayReader = new ArrayReaderImpl();
        String nonExistingFilename = "data\\non_existing.txt";
        Assertions.assertThrows(CustomException.class, () -> {
            arrayReader.readArrayAll(nonExistingFilename);
        });
    }
}

