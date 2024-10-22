package com.example.segurovehiculos.service.impl;

import com.example.segurovehiculos.dto.VehiculoPatenteMarcaDTO;
import com.example.segurovehiculos.dto.VehiculoPatenteMarcaModeloDTO;
import com.example.segurovehiculos.dto.VehiculoSiniestro;
import com.example.segurovehiculos.repository.IVehicleRepository;
import com.example.segurovehiculos.service.IVehiculoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService implements IVehiculoService {
    private final IVehicleRepository vehicleRepository;

    public VehiculoService(IVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public List<String> getPatentes() {
        return vehicleRepository.getAllPatentes();
    }

    @Override
    public List<VehiculoPatenteMarcaDTO> getPatenteMarcaPorAnio() {
        return vehicleRepository.getPatenteMarcaOrderByAnioFabricacion();
    }

    @Override
    public List<String> getPatentesMuchasRuedas() {
        return vehicleRepository.getPatentesMayorIgualCuatroRuedasAnioActual();
    }

    @Override
    public List<VehiculoPatenteMarcaModeloDTO> getSiniestroMayor10000() {
        return vehicleRepository.getVehiculosConSiniestrosPerdidaEconomicaMayorDiezMil();
    }

    @Override
    public List<VehiculoSiniestro> getSumaPerdida() {
        return vehicleRepository.getVehiculosConSiniestrosPerdidaEconomicaMayorDiezMilSumaPerdidaEconomica();
    }
}
