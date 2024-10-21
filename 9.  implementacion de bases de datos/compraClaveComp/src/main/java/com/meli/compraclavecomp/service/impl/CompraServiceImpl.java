package com.meli.compraclavecomp.service.impl;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.compraclavecomp.dto.CompraDto;
import com.meli.compraclavecomp.dto.ResponseDto;
import com.meli.compraclavecomp.entity.Compra;
import com.meli.compraclavecomp.repository.IComprasRepository;
import com.meli.compraclavecomp.service.ICompraService;
import org.modelmapper.ModelMapper;
import org.modelmapper.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CompraServiceImpl implements ICompraService {
    @Autowired
    IComprasRepository comprasRepository;
    ModelMapper mapper = new ModelMapper();

    @Override
    public ResponseDto crearCompra(CompraDto nuevaCompra) {
        Compra compra = mapper.map(nuevaCompra, Compra.class);
        comprasRepository.save(compra);
        return new ResponseDto("Compra creada exitosamente",HttpStatus.OK);
    }
}
