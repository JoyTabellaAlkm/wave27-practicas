package ar.com.mercadolibre.elastic.repository;

import ar.com.mercadolibre.elastic.model.Articulo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticuloRepository extends ElasticsearchRepository<Articulo, Integer> {
    Articulo save(Articulo articulo);

    Optional<Articulo> findById(int id);

    Iterable<Articulo> findAll();

    void deleteById(int id);
}
