package ar.com.mercadolibre.blog.repository.impl;

import ar.com.mercadolibre.blog.entity.EntradaBlog;
import ar.com.mercadolibre.blog.exception.InvalidIdException;
import ar.com.mercadolibre.blog.repository.BlogRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BlogRepositoryImpl implements BlogRepository {
    Map<Integer, EntradaBlog> blogs;

    public BlogRepositoryImpl() {
        blogs = new HashMap<>();
    }

    public EntradaBlog getById(Integer id) {
        return blogs.get(id);
    }

    public List<EntradaBlog> getAll() {
        return blogs.values().stream().toList();
    }

    public Integer save(EntradaBlog blog) {
        Integer id = blog.getId();

        if (id == null || blogs.containsKey(id)) {
            throw new InvalidIdException("El id %d existe o es nulo".formatted(id));
        }

        blogs.put(id, blog);
        return id;
    }
}
