package com.mercadolibre.obrasliterariaselasticsearch.service;

import com.mercadolibre.obrasliterariaselasticsearch.dto.ObraLiterariaRequestDTO;
import com.mercadolibre.obrasliterariaselasticsearch.dto.ObraLiterariaResponseDTO;

import java.util.List;

public interface IObrasLiterariasService {
    List<ObraLiterariaResponseDTO> getObrasLiterariasByAutor(String autor);

    List<ObraLiterariaResponseDTO> getObrasLiterariasByTitle(String title);

    List<ObraLiterariaResponseDTO> getTop5ObrasLiterariasByPages();

    List<ObraLiterariaResponseDTO> getObrasLiterariasAfterYear(Integer year);

    List<ObraLiterariaResponseDTO> getObrasLiterariasByEditorial(String editorial);

    Boolean saveObraLiteraria(ObraLiterariaRequestDTO obraLiterariaRequestDTO);
}
