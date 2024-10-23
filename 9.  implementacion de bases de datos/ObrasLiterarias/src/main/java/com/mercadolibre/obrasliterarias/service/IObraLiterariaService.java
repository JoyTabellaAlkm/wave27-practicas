package com.mercadolibre.obrasliterarias.service;

import com.mercadolibre.obrasliterarias.dto.request.ObraLiterariaRequestDTO;
import com.mercadolibre.obrasliterarias.dto.response.ObraLiterariaResponseDTO;

import java.util.List;

public interface IObraLiterariaService {
    ObraLiterariaResponseDTO crearObraLiteraria(ObraLiterariaRequestDTO obraLiterariaRequestDTO);

    List<ObraLiterariaResponseDTO> buscarPorAutor(String autor);
    List<ObraLiterariaResponseDTO> buscarPorNombre(String nombre);
    List<ObraLiterariaResponseDTO> buscarTop5PorPaginas();
    List<ObraLiterariaResponseDTO> buscarPorAnio(Integer anio);
    List<ObraLiterariaResponseDTO> buscarPorEditorial(String editorial);

}
