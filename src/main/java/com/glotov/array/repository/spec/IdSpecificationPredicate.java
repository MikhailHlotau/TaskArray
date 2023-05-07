package com.glotov.array.repository.spec;

import com.glotov.array.entity.BaseArray;

public class IdSpecificationPredicate implements SpecificationPredicate{
    private int id;

    public IdSpecificationPredicate(int id) {
        this.id = id;
    }

    @Override
    public boolean test(BaseArray array) {
        return array.getId() == id;
    }
}
