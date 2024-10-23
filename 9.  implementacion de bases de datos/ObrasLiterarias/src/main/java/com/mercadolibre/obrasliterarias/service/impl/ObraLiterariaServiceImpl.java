package com.mercadolibre.obrasliterarias.service.impl;

import com.mercadolibre.obrasliterarias.dto.request.ObraLiterariaRequestDTO;
import com.mercadolibre.obrasliterarias.dto.response.ObraLiterariaResponseDTO;
import com.mercadolibre.obrasliterarias.entity.ObraLiteraria;
import com.mercadolibre.obrasliterarias.repository.ObraLiterariaRepository;
import com.mercadolibre.obrasliterarias.service.IObraLiterariaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObraLiterariaServiceImpl implements IObraLiterariaService {
    ModelMapper mapper = new ModelMapper();
    @Autowired
    ObraLiterariaRepository repository;

    @Override
    public ObraLiterariaResponseDTO crearObraLiteraria(ObraLiterariaRequestDTO obraLiterariaRequestDTO) {
        ObraLiteraria obraLiteraria = mapper.map(obraLiterariaRequestDTO, ObraLiteraria.class);
        repository.save(obraLiteraria);
        return mapper.map(obraLiteraria, ObraLiterariaResponseDTO.class);
    }

    @Override
    public List<ObraLiterariaResponseDTO> buscarPorAutor(String autor) {
        List<ObraLiteraria> obras = repository.findObraLiterariaByAutorContaining(autor);
        return obras.stream()
                .map(obra -> mapper.map(obra, ObraLiterariaResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObraLiterariaResponseDTO> buscarPorNombre(String nombre) {
        List<ObraLiteraria> obras = repository.findObraLiterariaByNombreContaining(nombre);
        return obras.stream()
                .map(obra -> mapper.map(obra, ObraLiterariaResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObraLiterariaResponseDTO> buscarTop5PorPaginas() {
        List<ObraLiteraria> obras = repository.findTop5ByOrderByCantidadPaginasDesc();
        return obras.stream()
                .map(obra -> mapper.map(obra, ObraLiterariaResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObraLiterariaResponseDTO> buscarPorAnio(Integer anio) {
        List<ObraLiteraria> obras = repository.findObraLiterariaByAnioPrimeraPublicacionBefore(anio);
        return obras.stream()
                .map(obra -> mapper.map(obra, ObraLiterariaResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObraLiterariaResponseDTO> buscarPorEditorial(String editorial) {
        List<ObraLiteraria> obras = repository.findObraLiterariaByEditorial(editorial);
        return obras.stream()
                .map(obra -> mapper.map(obra, ObraLiterariaResponseDTO.class))
                .collect(Collectors.toList());
    }
}
