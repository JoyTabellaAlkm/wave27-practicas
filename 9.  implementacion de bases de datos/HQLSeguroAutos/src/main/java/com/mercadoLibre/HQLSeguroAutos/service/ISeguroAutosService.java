package com.mercadoLibre.HQLSeguroAutos.service;

import com.mercadoLibre.HQLSeguroAutos.dto.*;

import java.util.List;

public interface ISeguroAutosService {
    ResponseDTO saveVehiculo(VehiculoRequestDTO vehiculo);
    ResponseDTO denunciarSiniestro(SiniestroRequestDTO siniestro);
    ResponseDTO getAllPatentes();
    List<PatenteMarcaResponseDTO> getPatenteMarcaByAnio();
    ResponseDTO getPatentesByRuedasAndAnio();
    List<PatenteMarcaModeloResponseDTO> getPatenteMarcaModeloByPerdida();
    ResponseDTO getPatenteMarcaModeloAndTotalPerdidaByPerdida();
}
