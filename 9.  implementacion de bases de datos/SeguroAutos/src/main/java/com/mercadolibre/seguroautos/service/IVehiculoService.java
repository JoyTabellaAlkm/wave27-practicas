package com.mercadolibre.seguroautos.service;

import com.mercadolibre.seguroautos.dto.PatenteRespondeDTO;
import com.mercadolibre.seguroautos.dto.PatenteYMarcaResponseDto;
import com.mercadolibre.seguroautos.dto.VehiculoDTO;
import com.mercadolibre.seguroautos.entity.Vehiculo;

import java.util.List;

public interface IVehiculoService {

    List<String> obtenerTodasPatentes();

    String agregarVehiculo(VehiculoDTO vehiculoDTO);

    List<Object[]> obtenerPorPatenteYMarca();

    List<String> obtenerPatentesVehiculosPorRuedasYAnio();

    List<Object[]> obtenerVehiculosConSiniestroMayorA10000();

    List<Object[]> obtenerVehiculosConSiniestroMayorA10000ConSumaPerdida();
}
