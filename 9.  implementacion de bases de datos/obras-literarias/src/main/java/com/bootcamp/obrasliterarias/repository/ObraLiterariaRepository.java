package com.bootcamp.obrasliterarias.repository;

import com.bootcamp.obrasliterarias.entity.ObraLiteraria;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, Long> {
    Iterable<ObraLiteraria> findAllByAutor(String autor);

    @Query("{\"match\": {\"nombre\": \"?0\"}}")
    Iterable<ObraLiteraria> findAllByPalabrasClave(String palabraClave);

    Iterable<ObraLiteraria> findTop5ByOrderByCantidadDePaginasDesc();

    Iterable<ObraLiteraria> findAllByAnioPrimeraPublicacionLessThan(int year);

    Iterable<ObraLiteraria> findAllByEditorial(String editorial);
}
