package org.bootcamp.repository;

import org.bootcamp.exception.NotFoundException;
import org.bootcamp.exception.RetryLimitException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Predicate;

public class Repository<T extends BaseEntity<UUID>> implements IRepository<T, UUID>{
    private Map<UUID, T> data;
    private int maxRetries;

    public Repository(int maxRetries) {
        this.data = new HashMap<>();
        this.maxRetries = maxRetries;
    }

    public Repository() {
        this(10);
    }

    @Override
    public void add(T entity) {
        UUID id = getFreeId();
        entity.setId(id);
        data.put(id, entity);
    }

    @Override
    public void add(List<T> entities) {
        entities.forEach(this::add);
    }

    @Override
    public T getById(UUID id) {
        validateIdExists(id);
        return data.get(id);
    }

    @Override
    public List<T> getAll() {
        return data.values().stream().toList();
    }

    @Override
    public List<T> getAllWhere(Predicate<T> predicate) {
        return getAll().stream().filter(predicate).toList();
    }

    @Override
    public void update(T t) {
        validateIdExists(t.getId());
        data.put(t.getId(), t);
    }

    @Override
    public void remove(T entity) {
        removeById(entity.getId());
    }

    @Override
    public void removeById(UUID id) {
        validateIdExists(id);
        data.remove(id);
    }

    @Override
    public boolean exists(UUID id) {
        return data.containsKey(id);
    }

    @Override
    public boolean exists(T entity) {
        return exists(entity.getId());
    }

    private UUID getFreeId() {
        int retries = 0;

        while (retries < maxRetries) {
            UUID id = UUID.randomUUID();

            if (!data.containsKey(id)) {
                return id;
            }

            retries++;
        }

        throw new RetryLimitException("No se pudo generar un id único después de %d intentos".formatted(maxRetries));
    }

    private void validateIdExists(UUID id) {
        if (!data.containsKey(id)) {
            throw new NotFoundException("No se encontró la entidad con id %s".formatted(id));
        }
    }
}
