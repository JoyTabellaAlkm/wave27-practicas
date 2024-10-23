package ar.com.mercadolibre.obras.repository;

import ar.com.mercadolibre.obras.model.Obra;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ObraRepository extends ElasticsearchRepository<Obra, Integer> {
    List<Obra> findByNombreContaining(String name);

    @Query("{\"match\": {\"nombre\": {\"query\": \"?0\", \"fuzziness\": \"AUTO\"}}}")
    List<Obra> findByNombreSimilar(String name);

    List<Obra> findByAutorMatches(String autor);

    List<Obra> findTop5ByOrderByPaginasDesc();

    List<Obra> findByAnioPublicacionBefore(Integer year);

    List<Obra> findByEditorial(String editorial);

    <S extends Obra> List<S> saveAll(Iterable<S> entities);
}
