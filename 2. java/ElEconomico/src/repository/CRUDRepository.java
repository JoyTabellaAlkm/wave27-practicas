package repository;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository<T> {
    void save(T obj);
    void delete(long id);
    Optional<T> searchById(long id);
    List<T> searchAll();
    void print();
}
