package com.mercadoLibre.HQLSeguroAutos.service;

import com.mercadoLibre.HQLSeguroAutos.dto.*;
import com.mercadoLibre.HQLSeguroAutos.entity.Siniestro;
import com.mercadoLibre.HQLSeguroAutos.entity.Vehiculo;
import com.mercadoLibre.HQLSeguroAutos.repository.ISeguroAutosRepository;
import com.mercadoLibre.HQLSeguroAutos.repository.ISiniestrosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeguroAutosServiceImpl implements ISeguroAutosService{

    @Autowired
    private ISeguroAutosRepository seguroAutosRepository;
    @Autowired
    private ISiniestrosRepository siniestrosRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseDTO saveVehiculo(VehiculoRequestDTO vehiculo) {
        Vehiculo vehiculoEntity = modelMapper.map(vehiculo, Vehiculo.class);
        seguroAutosRepository.save(vehiculoEntity);
        return new ResponseDTO(201, List.of("Vehiculo guardado correctamente"));
    }

    @Override
    public ResponseDTO denunciarSiniestro(SiniestroRequestDTO siniestro) {
        Vehiculo vehiculo = seguroAutosRepository.findByPatente(siniestro.getVehiculoDenunciado()).orElseThrow(() -> new RuntimeException("Patente no encontrada"));
        Siniestro siniestroEntity = modelMapper.map(siniestro, Siniestro.class);
        siniestroEntity.setVehiculo(vehiculo);
        siniestrosRepository.save(siniestroEntity);
        return new ResponseDTO(201, List.of("Siniestro denunciado correctamente"));
    }

    @Override
    public ResponseDTO getAllPatentes() {
        List<String> patentes = seguroAutosRepository.getAllPatentes();
        return new ResponseDTO(200, patentes);
    }

    @Override
    public List<PatenteMarcaResponseDTO> getPatenteMarcaByAnio() {
        List<Vehiculo> vehiculos = seguroAutosRepository.getPatenteAndMarcaOrderByAnio();
        List<PatenteMarcaResponseDTO> dto = new ArrayList<>();
        vehiculos.forEach(v -> {
            PatenteMarcaResponseDTO patenteMarcaResponseDTO = new PatenteMarcaResponseDTO();
            patenteMarcaResponseDTO.setPatente(v.getPatente());
            patenteMarcaResponseDTO.setMarca(v.getMarca());
            dto.add(patenteMarcaResponseDTO);
        });
        return dto;
    }

    @Override
    public ResponseDTO getPatentesByRuedasAndAnio() {
        List<String> patentes = seguroAutosRepository.getPatenteByCantidadRuedasAndAnioFabricacion();
        return new ResponseDTO(200, patentes);
    }

    @Override
    public List<PatenteMarcaModeloResponseDTO> getPatenteMarcaModeloByPerdida() {
        List<Vehiculo> vehiculos = seguroAutosRepository.getAllBySiniestroPerdida();
        List<PatenteMarcaModeloResponseDTO> dto = new ArrayList<>();
        vehiculos.forEach(v -> {
            PatenteMarcaModeloResponseDTO patenteMarcaModeloResponseDTO = new PatenteMarcaModeloResponseDTO();
            patenteMarcaModeloResponseDTO.setPatente(v.getPatente());
            patenteMarcaModeloResponseDTO.setMarca(v.getMarca());
            patenteMarcaModeloResponseDTO.setModelo(v.getModelo());
            dto.add(patenteMarcaModeloResponseDTO);
        });
        return dto;
    }

    @Override
    public ResponseDTO getPatenteMarcaModeloAndTotalPerdidaByPerdida() {
        return null;
    }
}
