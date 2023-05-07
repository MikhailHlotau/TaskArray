package com.glotov.array.reader;

import com.glotov.array.exception.CustomException;

import java.util.ArrayList;

public interface ArrayReader {
 /*   int[] readArray(String filename);

    ArrayList<int[]> readArray7Java(String filename) throws CustomException;*/

    ArrayList<int[]> readArrayAll(String filename) throws CustomException;
}
