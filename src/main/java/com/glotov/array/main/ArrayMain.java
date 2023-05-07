package com.glotov.array.main;

import com.glotov.array.creator.BaseArrayFactory;
import com.glotov.array.creator.RepositoryCreator;
import com.glotov.array.entity.BaseArray;
import com.glotov.array.exception.CustomException;
import com.glotov.array.reader.ArrayReader;
import com.glotov.array.reader.impl.ArrayReaderImpl;
import com.glotov.array.repository.ArrayRepository;
import com.glotov.array.service.ArraySort;
import com.glotov.array.service.impl.ArraySearchImpl;
import com.glotov.array.service.impl.ArraySortImpl;

import java.util.*;

public class ArrayMain {
    public static void main(String[] args) {

        ArrayReader reader = new ArrayReaderImpl();
        try {
            ArrayList<int[]> arraysList = reader.readArrayAll("data\\arrays.txt");
            List<BaseArray> newArray = BaseArrayFactory.createBaseArrays(arraysList);
            System.out.println(newArray);
            ArrayRepository arrayRepository = RepositoryCreator.createFromListObject(newArray);
            System.out.println(arrayRepository);
            ArraySortImpl sort = new ArraySortImpl(arrayRepository);
            System.out.println("//////////////////");
            sort.sortByMin();
            System.out.println(arrayRepository);
            sort.sortByMax();
            System.out.println(arrayRepository);
            sort.sortById();
            System.out.println(arrayRepository);
            sort.sortBySum();
            System.out.println(arrayRepository);
            sort.sortByAverage();
            System.out.println(arrayRepository);
            sort.sortByFirstElement();
            System.out.println(arrayRepository);
            ArraySearchImpl search = new ArraySearchImpl(arrayRepository);
            System.out.println(search.findByMaxMore(10));
            System.out.println(search.findByCount(4));
        } catch (CustomException e) {
            System.err.println(e);
        }

        ArrayRepository repository;
        ArraySort arraySort;
        List<BaseArray> expectedArrayList;


        repository = new ArrayRepository();
        BaseArray array1 = new BaseArray(new int[]{1, 2, 3});
        BaseArray array2 = new BaseArray(new int[]{4, 5, 6});
        BaseArray array3 = new BaseArray(new int[]{7, 8, 9});
        BaseArray array4 = new BaseArray(new int[]{10, 11, 12});
        repository.addArray(array1);
        repository.addArray(array2);
        repository.addArray(array3);
        repository.addArray(array4);
        arraySort = new ArraySortImpl(repository);
        expectedArrayList = Arrays.asList(array1, array2, array3, array4);


        Collections.shuffle(expectedArrayList); // перемешиваем массивы, чтобы порядок id был случайным
        arraySort.sortById();
        System.out.println(Arrays.toString(expectedArrayList.toArray()));
        System.out.println(Arrays.toString(repository.getArrayList().toArray()));

    }
}
