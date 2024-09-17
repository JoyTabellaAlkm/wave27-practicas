package org.example;

import java.util.List;

public interface IRepositorio<T> {

    void save(T entity);
    void delete(T entity);
    List<T> getAll();
}
