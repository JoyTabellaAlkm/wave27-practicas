package ar.com.mercadolibre.elastic.repository;

import ar.com.mercadolibre.elastic.domain.Articulo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IArticuloRepository extends ElasticsearchRepository<Articulo, String> {
}
