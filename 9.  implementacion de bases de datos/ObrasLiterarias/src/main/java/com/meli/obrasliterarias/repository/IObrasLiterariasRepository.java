package com.meli.obrasliterarias.repository;

import com.meli.obrasliterarias.model.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IObrasLiterariasRepository extends ElasticsearchRepository<ObraLiteraria, Long> {

    List<ObraLiteraria> findByAutor(String name);

    List<ObraLiteraria> findByTituloContaining(String word);

    List<ObraLiteraria> findTop5ByOrderByCantidadPaginasDesc();

    List<ObraLiteraria> findByAnioPublicacionBefore(String year);

    List<ObraLiteraria> findByEditorial(String editorial);
}
