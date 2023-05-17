package com.glotov.array.main;

import com.glotov.array.creator.BaseArrayFactory;
import com.glotov.array.creator.RepositoryCreator;
import com.glotov.array.entity.BaseArray;
import com.glotov.array.entity.Warehouse;
import com.glotov.array.exception.CustomException;
import com.glotov.array.reader.ArrayReader;
import com.glotov.array.reader.impl.ArrayReaderImpl;
import com.glotov.array.repository.ArrayRepository;

import java.util.*;

public class ArrayMain {
    public static void main(String[] args) {

        ArrayReader reader = new ArrayReaderImpl();
        try {
            List<BaseArray> newArraysList = BaseArrayFactory.createBaseArrays(reader.readArrayAll("data\\arrays.txt"));
            System.out.println(newArraysList);
            ArrayRepository arrayRepository = RepositoryCreator.createFromListObject(newArraysList);
            System.out.println(arrayRepository);
            System.out.println("//////////////////");
            arrayRepository.sortByMin();
            System.out.println(arrayRepository);
            arrayRepository.sortByMax();
            System.out.println(arrayRepository);
            arrayRepository.sortById();
            System.out.println(arrayRepository);
            arrayRepository.sortBySum();
            System.out.println(arrayRepository);
            arrayRepository.sortByAverage();
            System.out.println(arrayRepository);
            arrayRepository.sortByFirstElement();
            System.out.println(arrayRepository);
            System.out.println(arrayRepository.findByMaxMore(10));
            System.out.println(arrayRepository.findByCount(5));

            System.out.println(Warehouse.getInstance());

        } catch (CustomException e) {
            System.err.println(e);
        }
    }
}
