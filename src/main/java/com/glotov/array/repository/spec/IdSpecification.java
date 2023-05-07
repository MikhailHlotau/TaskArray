package com.glotov.array.repository.spec;

import com.glotov.array.entity.BaseArray;

public class IdSpecification implements Specification{
    private int id;

    public IdSpecification(int id) {
        this.id = id;
    }


    @Override
    public boolean specify(BaseArray array) {
        return array.getId() == id;
    }
}
