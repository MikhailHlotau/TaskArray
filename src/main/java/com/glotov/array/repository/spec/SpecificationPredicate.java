package com.glotov.array.repository.spec;

import com.glotov.array.entity.BaseArray;

import java.util.function.Predicate;

public interface SpecificationPredicate extends Predicate<BaseArray> {
    boolean test(BaseArray array);
}
