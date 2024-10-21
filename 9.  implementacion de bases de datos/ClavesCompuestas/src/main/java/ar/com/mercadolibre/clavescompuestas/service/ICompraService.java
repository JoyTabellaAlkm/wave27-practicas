package ar.com.mercadolibre.clavescompuestas.service;

import ar.com.mercadolibre.clavescompuestas.dto.CompraItemDTO;

import java.util.List;

public interface ICompraService {
    List<CompraItemDTO> getAllCompraItem();
}
