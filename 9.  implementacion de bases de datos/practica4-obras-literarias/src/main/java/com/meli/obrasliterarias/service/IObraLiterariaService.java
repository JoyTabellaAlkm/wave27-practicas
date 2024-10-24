package com.meli.obrasliterarias.service;

import com.meli.obrasliterarias.dto.ObraLiterariaDto;
import com.meli.obrasliterarias.dto.ResponseDto;
import com.meli.obrasliterarias.model.ObraLiteraria;

import java.util.List;

public interface IObraLiterariaService {
    ResponseDto createBook(ObraLiterariaDto obraLiteraria);
    List<ObraLiterariaDto> findByAutor(String autor);
    List<ObraLiterariaDto> findByWordInTitle(String word);
    List<ObraLiterariaDto> topFiveByPages();
    List<ObraLiterariaDto> findByYear(String year);
    List<ObraLiterariaDto> findByEditorial(String editorial);
}
