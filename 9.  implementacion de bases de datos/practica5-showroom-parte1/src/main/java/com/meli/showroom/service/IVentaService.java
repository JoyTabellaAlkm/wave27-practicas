package com.meli.showroom.service;

import com.meli.showroom.dto.PrendaResponseDto;
import com.meli.showroom.dto.ResponseDto;
import com.meli.showroom.dto.VentaRequestDto;
import com.meli.showroom.dto.VentaResponseDto;

import java.util.List;

public interface IVentaService {
    VentaResponseDto nuevaVenta(VentaRequestDto venta);
    List<VentaResponseDto> listarVentas(String date);
    VentaResponseDto devolverVenta(Integer number);
    VentaResponseDto actualizarVenta(Integer number, VentaRequestDto ventaRequestDto);
    ResponseDto eliminarVenta(Integer number);
    List<PrendaResponseDto> listarPrendasVenta(Integer number);
}
