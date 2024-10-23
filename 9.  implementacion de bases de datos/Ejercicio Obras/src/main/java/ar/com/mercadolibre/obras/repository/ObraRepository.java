package ar.com.mercadolibre.obras.repository;

import ar.com.mercadolibre.obras.model.Obra;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ObraRepository extends ElasticsearchRepository<Obra, Integer> {
    Page<Obra> findByNombreContaining(String name, Pageable pageable);

    @Query("{\"match\": {\"nombre\": {\"query\": \"?0\", \"fuzziness\": \"AUTO\"}}}")
    Page<Obra> findByNombreSimilar(String name, Pageable pageable);

    Page<Obra> findByAutorMatches(String autor, Pageable pageable);

    Page<Obra> findTop5ByOrderByPaginasDesc(Pageable pageable);

    Page<Obra> findByAnioPublicacionBefore(Integer year, Pageable pageable);

    Page<Obra> findByEditorial(String editorial, Pageable pageable);
}
