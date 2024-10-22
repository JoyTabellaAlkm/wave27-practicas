package com.mercadolibre.clavescompuestas.service;

import com.mercadolibre.clavescompuestas.dto.request.CompraRequestDto;
import com.mercadolibre.clavescompuestas.dto.response.CompraResponseDto;

public interface ICompraService {

    CompraResponseDto createCompra(CompraRequestDto compraRequestDto);
}
