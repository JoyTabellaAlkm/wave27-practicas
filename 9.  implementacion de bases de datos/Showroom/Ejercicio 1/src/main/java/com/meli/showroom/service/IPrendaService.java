package com.meli.showroom.service;

import com.meli.showroom.dto.PrendaRequestDto;
import com.meli.showroom.dto.PrendaResponseDto;
import com.meli.showroom.dto.ResponseDto;

import java.util.List;

public interface IPrendaService {

    PrendaResponseDto nuevaPrenda(PrendaRequestDto prenda);
    List<PrendaResponseDto> listarPrendas(String name);
    PrendaResponseDto devolverPrenda(Long code);
    PrendaResponseDto actualizarPrenda(Long code, PrendaRequestDto prendaResponseDto);
    ResponseDto eliminarPrenda(Long code);
    List<PrendaResponseDto> listarPrendasPorTalla(String size);
}