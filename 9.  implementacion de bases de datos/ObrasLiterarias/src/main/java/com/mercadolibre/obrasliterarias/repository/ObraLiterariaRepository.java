package com.mercadolibre.obrasliterarias.repository;

import com.mercadolibre.obrasliterarias.dto.response.ObraLiterariaResponseDTO;
import com.mercadolibre.obrasliterarias.entity.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObraLiterariaRepository  extends ElasticsearchRepository<ObraLiteraria,Long> {

    List<ObraLiteraria> findObraLiterariaByAutorContaining(String autor);
    List<ObraLiteraria> findObraLiterariaByNombreContaining(String nombre);
    List<ObraLiteraria> findTop5ByOrderByCantidadPaginasDesc();
    List<ObraLiteraria> findObraLiterariaByAnioPrimeraPublicacionBefore(Integer anio);
    List<ObraLiteraria> findObraLiterariaByEditorial(String editorial);

}
