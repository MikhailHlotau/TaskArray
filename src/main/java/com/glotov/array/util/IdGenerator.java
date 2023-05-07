package com.glotov.array.util;

import com.glotov.array.exception.CustomException;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class IdGenerator {
    private static final Set<Integer> usedIds = new HashSet<>();

    public static int generateId() throws CustomException {
        int id;
        Random random = new Random();
        int attempts = 0;
        do {
            id = random.nextInt(900) + 100;
            attempts++;
            if (attempts > 1000) {
                throw new CustomException("Failed to generate a unique ID");
            }
        } while (usedIds.contains(id));
        usedIds.add(id);
        return id;
    }
}
