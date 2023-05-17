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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayReaderImpl implements ArrayReader {

    private static final Logger logger = LogManager.getLogger(ArrayReaderImpl.class);
    private static final String SPACE_DELIMITER = "\\s+";

    public ArrayList<int[]> readArrayAll(String filename) throws CustomException {
        Path path = Paths.get(filename);
        if (!Files.exists(path)) {
            logger.error("File " + filename + " does not exist");
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
        } catch (IOException e) {
            logger.error("Error reading file: " + filename, e);
            throw new CustomException(e);
        }
        return matrix;
    }
}

