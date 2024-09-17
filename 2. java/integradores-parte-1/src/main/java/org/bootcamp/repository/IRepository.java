package org.bootcamp.repository;

import java.util.List;
import java.util.function.Predicate;

public interface IRepository<T extends BaseEntity<K>, K> {
    void add(T entity);
    void add(List<T> entities);

    T getById(K id);
    List<T> getAll();
    List<T> getAllWhere(Predicate<T> predicate);

    void update(T t);

    void remove(T entity);
    void removeById(K id);

    boolean exists(K id);
    boolean exists(T entity);
}
