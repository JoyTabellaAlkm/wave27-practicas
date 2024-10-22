package com.mercadolibre.seguroautos.service;

import com.mercadolibre.seguroautos.Query.VehiculoSiniestroCostoInfo;
import com.mercadolibre.seguroautos.Query.VehiculoSiniestroInfo;
import com.mercadolibre.seguroautos.dto.*;
import com.mercadolibre.seguroautos.entity.Siniestro;
import com.mercadolibre.seguroautos.entity.Vehiculo;
import com.mercadolibre.seguroautos.repository.VehiculoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehiculoService implements IVehiculoService{

    @Autowired
    VehiculoRepository vehiculoRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public String agregarVehiculo(VehiculoDTO vehiculoDTO) {
        System.out.println(vehiculoDTO.toString());
        Vehiculo vehiculo = modelMapper.map(vehiculoDTO, Vehiculo.class);
        System.out.println(vehiculo.toString());

        vehiculo.setSiniestros(new ArrayList<>());

        for (SiniestroDTO siniestroDTO : vehiculoDTO.getSiniestroDTO()) {
            Siniestro siniestro = modelMapper.map(siniestroDTO, Siniestro.class);
            siniestro.setVehiculoDenunciado(vehiculo);
            vehiculo.getSiniestros().add(siniestro);
        }

        vehiculoRepository.save(vehiculo);

        return "Vehiculo creado con ID: " + vehiculo.getId();
    }

    @Override
    public List<String> obtenerTodasPatentes(){
        return vehiculoRepository.findAllPatentes();
    }

    @Override
    public List<PatenteYMarcaResponseDto> obtenerPorPatenteYMarca(){
        List<Vehiculo> vehiculoList = vehiculoRepository.findAllByPatenteAndMarca();
        List<PatenteYMarcaResponseDto> vehiculoDTOS = new ArrayList<>(List.of());
        vehiculoList.forEach(vehiculo1 ->
                vehiculoDTOS.add(modelMapper.map(vehiculo1,  PatenteYMarcaResponseDto.class)));
        return vehiculoDTOS;
    }

    @Override
    public List<String> obtenerPorCantidadDeRuedasAndCantidadRuedas() {
        return vehiculoRepository.findAllByCantidadRuedasAndAnioFabricacion();
    }

    @Override
    public List<VehiculoSiniestroInfoDTO> listarSiniestrosMayores() {
        List<VehiculoSiniestroInfo> vehiculoSiniestroInfo = vehiculoRepository.findVehiculosConSiniestroMayorA10000();

        List<VehiculoSiniestroInfoDTO> vehiculos = modelMapper.map(vehiculoSiniestroInfo, new TypeToken<List<VehiculoSiniestroInfoDTO>>() {}.getType());

        return vehiculos;
    }

    @Override
    public VehiculoSiniestroInfoTotalDTO listarSiniestrosMayoresTotal() {

        List<VehiculoSiniestroCostoInfo> vehiculoSiniestroInfo = vehiculoRepository.findVehiculosConSiniestroMayorA10000Total();

        List<VehiculoSiniestroInfoDTO> vehiculos = modelMapper.map(vehiculoSiniestroInfo, new TypeToken<List<VehiculoSiniestroInfoDTO>>() {}.getType());

        Double perdiaTotal = vehiculoSiniestroInfo.stream().mapToDouble(vehiculo -> vehiculo.getPerdidaEconomica()).sum();

        VehiculoSiniestroInfoTotalDTO vehiculoSiniestroInfoTotalDTO
                = new VehiculoSiniestroInfoTotalDTO(vehiculos, perdiaTotal);

        return vehiculoSiniestroInfoTotalDTO;
    }


}
