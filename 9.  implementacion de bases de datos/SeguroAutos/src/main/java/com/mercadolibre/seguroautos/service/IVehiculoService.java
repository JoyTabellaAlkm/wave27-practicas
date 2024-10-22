package com.mercadolibre.seguroautos.service;

import com.mercadolibre.seguroautos.dto.*;

import java.util.List;

public interface IVehiculoService {

    //0
    String agregarVehiculo(VehiculoDTO vehiculoDTO);

    //1
    List<String> obtenerTodasPatentes();

    //2
    List<PatenteYMarcaResponseDto> obtenerPorPatenteYMarca();

    //3
    List<String> obtenerPorCantidadDeRuedasAndCantidadRuedas();

    //4
    List<VehiculoSiniestroInfoDTO> listarSiniestrosMayores();

    //5
    VehiculoSiniestroInfoTotalDTO listarSiniestrosMayoresTotal();


}
