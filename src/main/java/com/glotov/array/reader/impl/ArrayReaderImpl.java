package com.glotov.array.reader.impl;

import com.glotov.array.exception.CustomException;
import com.glotov.array.reader.ArrayReader;
import com.glotov.array.validator.StringArrayValidator;
import com.glotov.array.validator.impl.StringArrayValidatorImpl;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayReaderImpl implements ArrayReader {

    private static final String DEFAULT_FILENAME = "data\\arrays.txt";
    private static final String SPACE_DELIMITER = "\\s+";

   /* public int[] readArray(String filename) {
        Path path = Path.of(filename);
        if (!Files.exists(path)) {
            System.out.println("file " + filename + " not exist");
            filename = DEFAULT_FILENAME;// or Exception
        }
        BufferedReader reader = null;
        int[] arrTemp = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String tmp;
            StringArrayValidator validator = new StringArrayValidatorImpl();
            while (arrTemp == null){
                tmp = reader.readLine();
                if (validator.stringArrayValidate(tmp)) { //java 2
                    System.out.println(tmp);
                    String[] str = tmp.split(SPACE_DELIMITER);
                    System.out.println(Arrays.toString(str));
                    arrTemp = new int[str.length];
                    int counter = 0;
                    for (int i = 0; i < str.length; i++) {
                        if (validator.stringNumberValidate(str[i])) {
                            arrTemp[counter] = Integer.parseInt(str[i]);
                            counter++;
                        }

                    }
                }
            }

        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //
                }
            }
        }
        return arrTemp;
    }*/
/*
    @Override
    public ArrayList<int[]> readArray7Java(String filename) throws CustomException {
        Path path = Path.of(filename);
        if (!Files.exists(path)) {
            System.out.println("file " + filename + " not exist");
            filename = DEFAULT_FILENAME;// or Exception
        }
        Path path2 = FileSystems.getDefault().getPath(filename);
        ArrayList<int[]> list = new ArrayList<>();
        int [] result;
        try {//java7
            List<String> lines = Files.readAllLines(path2);
            System.out.println(lines);
            System.out.println(lines.size());
            StringArrayValidator validator = new StringArrayValidatorImpl();
            for (int i = 0; i < lines.size(); i++) {
                String strNum = lines.get(i);
                if(validator.stringArrayValidate(strNum)){
                    String[] numArr = strNum.split(SPACE_DELIMITER);
                    result = new int[numArr.length];
                    for (int j = 0; j < numArr.length; j++) {
                        result[j] = Integer.parseInt(numArr[j]);
                    }
                    list.add(result);
                }

            }
            list.stream().map(Arrays::toString).forEach(System.out::println);
            return list;
        } catch (IOException e) {
            throw new CustomException(e);
        }
    }*/

    public ArrayList<int[]> readArrayAll(String filename) throws CustomException {
        Path path = Path.of(filename);
        if (!Files.exists(path)) {
            System.out.println("file " + filename + " not exist");
        }
        ArrayList<int[]> matrix = null;
        try {
            File file = new File(String.valueOf(path));
            Scanner scanner = new Scanner(path);
            matrix = new ArrayList<>();
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
            scanner.close();
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

