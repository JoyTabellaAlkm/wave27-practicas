package repository;

import java.util.List;
import java.util.Optional;

public interface ICRUD<T> {
    public void save(T object);
    public List<T> getAll();
    public Optional<T> getById(Long id);
    public void update(T object);
    public void delete(Long id);
}
