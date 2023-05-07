package com.glotov.array.repository.spec;

import com.glotov.array.entity.BaseArray;

public interface Specification {
    boolean specify(BaseArray array);
}
