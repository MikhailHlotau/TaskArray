package com.glotov.array.reader.impl;

import com.glotov.array.exception.CustomException;
import com.glotov.array.reader.ArrayReader;
import com.glotov.array.validator.StringArrayValidator;
import com.glotov.array.validator.impl.StringArrayValidatorImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayReaderImpl implements ArrayReader {

    private static final String DEFAULT_FILENAME = "data\\arrays.txt";
    private static final String SPACE_DELIMITER = "\\s+";

    public ArrayList<int[]> readArrayAll(String filename) throws CustomException {
        Path path = Paths.get(filename);
        if (!Files.exists(path)) {
            throw new CustomException("File " + filename + " does not exist");
        }
        ArrayList<int[]> matrix = new ArrayList<>();
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNextLine()) {
                StringArrayValidator validator = new StringArrayValidatorImpl();
                String line = scanner.nextLine();
                if (validator.stringArrayValidate(line)) {
                    String[] nums = line.split(SPACE_DELIMITER);
                    int[] row = new int[nums.length];
                    for (int i = 0; i < nums.length; i++) {
                        row[i] = Integer.parseInt(nums[i]);
                    }
                    matrix.add(row);
                }
            }
            for (int[] row : matrix) {
                System.out.println(Arrays.toString(row));
            }
        } catch (IOException e) {
            throw new CustomException(e);
        }
        return matrix;
    }

    @Override
    public String toString() {
        return "ArrayReaderImpl{}";
    }

}

