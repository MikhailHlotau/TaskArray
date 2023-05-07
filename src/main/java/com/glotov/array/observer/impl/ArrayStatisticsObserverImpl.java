package com.glotov.array.observer.impl;

import com.glotov.array.entity.ArrayStatistics;
import com.glotov.array.entity.BaseArray;
import com.glotov.array.entity.Warehouse;
import com.glotov.array.observer.ArrayStatisticsObserver;

public class ArrayStatisticsObserverImpl implements ArrayStatisticsObserver {
    @Override
    public void changeArrayElement(BaseArray array) {
        ArrayStatistics statistics = new ArrayStatistics(array);
        int id = array.getId();
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.put(id, statistics);
    }
}
