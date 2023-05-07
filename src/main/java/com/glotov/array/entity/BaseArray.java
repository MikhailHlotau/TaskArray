package com.glotov.array.entity;

import com.glotov.array.exception.CustomException;
import com.glotov.array.observer.ArrayStatisticsObserver;
import com.glotov.array.observer.impl.ArrayStatisticsObserverImpl;
import com.glotov.array.util.IdGenerator;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class BaseArray {
    private static int nextId = 1;
    private int id;

    private int[] array;

    private ArrayStatisticsObserver observer;


    public BaseArray(int[] array) throws CustomException {
        setArray(array);
        this.id = nextId;
        nextId++;
        observer = new ArrayStatisticsObserverImpl();
    }

    public BaseArray() {

    }

    public BaseArray(int id, int[] array) throws CustomException {
        this.id = id;
        setArray(array);
    }

    public void removeObserver() {
        observer = null;
    }
    public void addObserver() {
        observer = new ArrayStatisticsObserverImpl();
    }

    public int getId() {
        return id;
    }


    public int[] getArray() {
        return array;
    }


    public void setArray(int[] array) throws CustomException {
        if (array != null && array.length > 0) {
            this.array = array;
            notifyObserver();
        } else {
            throw new CustomException("Invalid array");
        }
    }

    private void notifyObserver() {
        if (observer != null) {
            observer.changeArrayElement(this);
        }
    }



    public int getSize() {
        return array.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseArray baseArray = (BaseArray) o;
        return id == baseArray.id && Arrays.equals(array, baseArray.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public String toString() {
        return "BaseArray{" +
                "id=" + id +
                ", elements=" + Arrays.toString(array) +
                '}';
    }
}



