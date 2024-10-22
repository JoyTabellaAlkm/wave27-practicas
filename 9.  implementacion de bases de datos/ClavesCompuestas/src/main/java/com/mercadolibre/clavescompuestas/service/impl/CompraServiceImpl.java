package com.mercadolibre.clavescompuestas.service.impl;

import com.mercadolibre.clavescompuestas.dto.request.CompraRequestDto;
import com.mercadolibre.clavescompuestas.dto.response.CompraResponseDto;
import com.mercadolibre.clavescompuestas.entity.Compra;
import com.mercadolibre.clavescompuestas.repository.ICompraRepository;
import com.mercadolibre.clavescompuestas.service.ICompraService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraServiceImpl implements ICompraService {
ModelMapper mapper = new ModelMapper();

@Autowired
    ICompraRepository repository;
    @Override
    public CompraResponseDto createCompra(CompraRequestDto compraRequestDto) {
        Compra compra = mapper.map(compraRequestDto, Compra.class);

        repository.save(compra);
        CompraResponseDto compraResponseDto = mapper.map(compra, CompraResponseDto.class);
        return compraResponseDto;
    }
}
