package com.glotov.array.entity;

import com.glotov.array.observer.ArrayStatisticsObserver;
import com.glotov.array.observer.impl.ArrayStatisticsObserverImpl;

import java.util.Arrays;
import java.util.Objects;

public class BaseArray {
    private static int nextId = 1;
    private int id;

    private int[] elements;

    private ArrayStatisticsObserver observer;


    public BaseArray(int[] elements) {
        setElements(elements);
        this.id = nextId;
        nextId++;
        observer = new ArrayStatisticsObserverImpl();
    }

    public BaseArray() {

    }

    public int getId() {
        return id;
    }


    public int[] getElements() {
        return elements;
    }

    public void setElements(int[] elements) {
        if(elements != null && elements.length > 0) {
            this.elements = elements;
        } else {
            this.elements = new int[]{0};
        }
        notifyObserver();
    }

    private void notifyObserver() {
        if (observer != null) {
            observer.changeArrayElement(this);
        }
    }


    public void removeObserver() {
        observer = null;
    }
    public void addObserver() {
        observer = new ArrayStatisticsObserverImpl();
    }

    public int getSize() {
        return elements.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseArray baseArray = (BaseArray) o;
        return id == baseArray.id && Arrays.equals(elements, baseArray.elements);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id);
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }

    @Override
    public String toString() {
        return "BaseArray{" +
                "id=" + id +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }
}



