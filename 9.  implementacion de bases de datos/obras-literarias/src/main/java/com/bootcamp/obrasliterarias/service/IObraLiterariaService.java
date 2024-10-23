package com.bootcamp.obrasliterarias.service;

import com.bootcamp.obrasliterarias.dto.CreateObraLiterariaDto;
import com.bootcamp.obrasliterarias.dto.ObraLiterariaDto;

import java.util.List;

public interface IObraLiterariaService {
    String createObraLiteraria(CreateObraLiterariaDto createObraLiterariaDto);

    List<ObraLiterariaDto> getObrasLiterarias(String autor);

    List<ObraLiterariaDto> searchObrasLiterarias(String palabraClave);

    List<ObraLiterariaDto> getTop5ObrasLiterarias();

    List<ObraLiterariaDto> getObrasLiterariasBeforeYear(int year);

    List<ObraLiterariaDto> getObrasLiterariasByEditorial(String editorial);
}
