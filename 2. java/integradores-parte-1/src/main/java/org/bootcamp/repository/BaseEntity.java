package org.bootcamp.repository;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public abstract class BaseEntity<T> {
    @Getter @Setter(AccessLevel.PROTECTED)
    protected T id;
}
