package com.mercadolibre.showroom.service.venta;

import com.mercadolibre.showroom.dto.PrendaResponseDTO;
import com.mercadolibre.showroom.dto.ResponseDTO;
import com.mercadolibre.showroom.dto.VentaRequestDTO;
import com.mercadolibre.showroom.dto.VentaResponseDTO;
import com.mercadolibre.showroom.entity.Venta;

import java.util.List;

public interface IVentaService {

    VentaResponseDTO agregarVenta(VentaRequestDTO ventaRequestDTO);
    ResponseDTO eliminarVenta(Long id);
    List<VentaResponseDTO> obtenerVentas();
    ResponseDTO actualizarVenta(Long number, VentaRequestDTO ventaRequestDTO);
    VentaResponseDTO getVentaByID(Long id);
    List<PrendaResponseDTO> devolverPrendasPorFecha(String date);
    List<PrendaResponseDTO> getPrendasByVenta(Long number);
}
