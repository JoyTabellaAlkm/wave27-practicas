package com.mercadolibre.seguroautos.service;

import com.mercadolibre.seguroautos.dto.PatenteRespondeDTO;
import com.mercadolibre.seguroautos.dto.PatenteYMarcaResponseDto;
import com.mercadolibre.seguroautos.dto.VehiculoDTO;
import com.mercadolibre.seguroautos.entity.Vehiculo;
import com.mercadolibre.seguroautos.repository.VehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehiculoService implements IVehiculoService{

    @Autowired
    VehiculoRepository vehiculoRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public String agregarVehiculo(VehiculoDTO vehiculoDTO){

        Vehiculo vehiculo = modelMapper.map(vehiculoDTO, Vehiculo.class);
        vehiculoRepository.save(vehiculo);

        return "Vehiculo creado con ID: " + vehiculo.getId();
    }

    @Override
    public List<String> obtenerTodasPatentes(){
        return vehiculoRepository.findAllPatentes();
    }

    @Override
    public List<Object[]> obtenerPorPatenteYMarca(){

        return vehiculoRepository.findAllByPatenteAndMarca();
    }

    @Override
    public List<String> obtenerPatentesVehiculosPorRuedasYAnio() {
        return vehiculoRepository.findAllPatentesVehiculosPorRuedasYAnio();
    }

    @Override
    public List<Object[]> obtenerVehiculosConSiniestroMayorA10000() {
        List<Object[]> vehi= vehiculoRepository.findVehiculosConSiniestroMayorA10000();
        return vehi;
    }

    @Override
    public List<Object[]> obtenerVehiculosConSiniestroMayorA10000ConSumaPerdida() {
        return vehiculoRepository.findVehiculosConSiniestroMayorA10000ConSumaPerdida();
    }


}
