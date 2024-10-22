package com.example.segurovehiculos.service;

import com.example.segurovehiculos.dto.VehiculoPatenteMarcaDTO;
import com.example.segurovehiculos.dto.VehiculoPatenteMarcaModeloDTO;
import com.example.segurovehiculos.dto.VehiculoSiniestro;

import java.util.List;

public interface IVehiculoService {
    List<String> getPatentes();

    List<VehiculoPatenteMarcaDTO> getPatenteMarcaPorAnio();

    List<String> getPatentesMuchasRuedas();

    List<VehiculoPatenteMarcaModeloDTO> getSiniestroMayor10000();

    List<VehiculoSiniestro> getSumaPerdida();
}
