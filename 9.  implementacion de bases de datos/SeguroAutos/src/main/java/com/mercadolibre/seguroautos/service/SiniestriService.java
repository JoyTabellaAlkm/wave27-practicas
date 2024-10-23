package com.mercadolibre.seguroautos.service;

import com.mercadolibre.seguroautos.dto.SiniestroDTO;
import com.mercadolibre.seguroautos.entity.Siniestro;
import com.mercadolibre.seguroautos.entity.Vehiculo;
import com.mercadolibre.seguroautos.repository.SiniestroRepository;
import com.mercadolibre.seguroautos.repository.VehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiniestriService  implements ISiniestroService{

    @Autowired
    SiniestroRepository siniestroRepository;
    @Autowired
    VehiculoRepository vehiculoRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String agregarSiniestro(SiniestroDTO siniestroDTO) {
        Vehiculo vehiculo =vehiculoRepository.findById(siniestroDTO.getVehicleId())
                .orElseThrow(()->new RuntimeException("Vehículo no encontrado"));
        Siniestro siniestro = modelMapper.map( siniestroDTO, Siniestro.class);
        siniestro.setVehiculoDenunciado(vehiculo);
        siniestroRepository.save(siniestro);
        return "Siniestro creado con ID: " + siniestro.getId();
    }
}
