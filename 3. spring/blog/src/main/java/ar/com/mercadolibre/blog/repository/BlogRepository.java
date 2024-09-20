package ar.com.mercadolibre.blog.repository;

import ar.com.mercadolibre.blog.entity.EntradaBlog;

import java.util.List;

public interface BlogRepository {
    EntradaBlog getById(Integer id);
    List<EntradaBlog> getAll();
    Integer save(EntradaBlog blog);
}
