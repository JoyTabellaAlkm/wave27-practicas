package com.meli.showroom.service;

import com.meli.showroom.dto.response.PrendaResponseDto;
import com.meli.showroom.dto.response.ResponseDto;
import com.meli.showroom.dto.request.VentaRequestDto;
import com.meli.showroom.dto.response.VentaResponseDto;

import java.util.List;

public interface IVentaService {
    VentaResponseDto nuevaVenta(VentaRequestDto venta);
    List<VentaResponseDto> listarVentas(String date);
    VentaResponseDto devolverVenta(String number);
    VentaResponseDto actualizarVenta(String number, VentaRequestDto ventaRequestDto);
    ResponseDto eliminarVenta(String number);
    List<PrendaResponseDto> listarPrendasVenta(String number);
}
