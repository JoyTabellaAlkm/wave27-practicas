package com.meli.showroom.service;

import com.meli.showroom.dto.request.PrendaRequestDto;
import com.meli.showroom.dto.response.PrendaResponseDto;
import com.meli.showroom.dto.response.ResponseDto;

import java.util.List;

public interface IPrendaService {

    PrendaResponseDto nuevaPrenda(PrendaRequestDto prenda);
    List<PrendaResponseDto> listarPrendas(String name);
    PrendaResponseDto devolverPrenda(String code);
    PrendaResponseDto actualizarPrenda(String code, PrendaRequestDto prendaResponseDto);
    ResponseDto eliminarPrenda(String code);
    List<PrendaResponseDto> listarPrendasPorTalla(String size);
}