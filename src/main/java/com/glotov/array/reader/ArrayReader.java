package com.glotov.array.reader;

import com.glotov.array.exception.CustomException;

import java.util.ArrayList;

public interface ArrayReader {

    ArrayList<int[]> readArrayAll(String filename) throws CustomException;
}
