package com.mercadolibre.showroom.service.prenda;

import com.mercadolibre.showroom.dto.PrendaRequestDTO;
import com.mercadolibre.showroom.dto.PrendaResponseDTO;
import com.mercadolibre.showroom.dto.ResponseDTO;

import java.util.List;

public interface IPrendaService {
    List<PrendaResponseDTO> obtenerPrendas();
    ResponseDTO eliminarPrenda(Long id);
    PrendaResponseDTO agregarPrenda(PrendaRequestDTO prendaRequestDTO);
    ResponseDTO actualizarPrenda(Long id, PrendaRequestDTO prendaRequestDTO);
    List<PrendaResponseDTO> obtenerPrendasPorNombre(String nombre);
    PrendaResponseDTO getPrendaByID (Long id);
    List<PrendaResponseDTO> obtenerPrendasPorTalle(String talle);

}