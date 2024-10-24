package ar.com.mercadolibre.showroomelastic.repository;

import ar.com.mercadolibre.showroomelastic.entity.Prenda;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPrendaRepository extends ElasticsearchRepository<Prenda, Long> {
    List<Prenda> findAllByTalle(String size);

    List<Prenda> findAllByNombreContainsIgnoreCase(String name);
}
