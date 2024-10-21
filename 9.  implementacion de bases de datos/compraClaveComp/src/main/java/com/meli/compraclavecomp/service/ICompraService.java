package com.meli.compraclavecomp.service;

import com.meli.compraclavecomp.dto.CompraDto;
import com.meli.compraclavecomp.dto.ResponseDto;
import com.meli.compraclavecomp.entity.Compra;

public interface ICompraService {
    ResponseDto crearCompra(CompraDto nuevaCompra);
}
