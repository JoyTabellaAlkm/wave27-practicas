package com.mercadolibre.obrasliterariaselasticsearch.repository;

import com.mercadolibre.obrasliterariaselasticsearch.entity.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IObrasLiterariasRepository extends ElasticsearchRepository<ObraLiteraria, String> {
    List<ObraLiteraria> findByAutorContainingIgnoreCase(String autor);
    List<ObraLiteraria> findByTituloContainingIgnoreCase(String title);
    List<ObraLiteraria> findByAnioPublicacionBeforeOrderByAnioPublicacion(Integer year);
    List<ObraLiteraria> findTop5ByOrderByPaginasDesc();
    List<ObraLiteraria> findByEditorial(String editorial);
}
