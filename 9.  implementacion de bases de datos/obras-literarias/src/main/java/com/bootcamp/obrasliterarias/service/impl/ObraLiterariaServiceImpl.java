package com.bootcamp.obrasliterarias.service.impl;

import com.bootcamp.obrasliterarias.dto.CreateObraLiterariaDto;
import com.bootcamp.obrasliterarias.dto.ObraLiterariaDto;
import com.bootcamp.obrasliterarias.entity.ObraLiteraria;
import com.bootcamp.obrasliterarias.repository.ObraLiterariaRepository;
import com.bootcamp.obrasliterarias.service.IObraLiterariaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ObraLiterariaServiceImpl implements IObraLiterariaService {
    private final ObraLiterariaRepository obraLiterariaRepository;
    private final ModelMapper modelMapper;

    public ObraLiterariaServiceImpl(ObraLiterariaRepository obraLiterariaRepository, ModelMapper modelMapper) {
        this.obraLiterariaRepository = obraLiterariaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public String createObraLiteraria(CreateObraLiterariaDto createObraLiterariaDto) {
        ObraLiteraria obra = modelMapper.map(createObraLiterariaDto, ObraLiteraria.class);
        return obraLiterariaRepository.save(obra).getId();
    }

    @Override
    public List<ObraLiterariaDto> getObrasLiterarias(String autor) {
        Iterable<ObraLiteraria> obras = autor == null
                ? obraLiterariaRepository.findAll()
                : obraLiterariaRepository.findAllByAutor(autor);
        return StreamSupport.stream(obras.spliterator(), false)
                .map(obra -> modelMapper.map(obra, ObraLiterariaDto.class))
                .toList();
    }

    @Override
    public List<ObraLiterariaDto> searchObrasLiterarias(String palabraClave) {
        Iterable<ObraLiteraria> obras = obraLiterariaRepository.findAllByPalabrasClave(palabraClave);
        return StreamSupport.stream(obras.spliterator(), false)
                .map(obra -> modelMapper.map(obra, ObraLiterariaDto.class))
                .toList();
    }

    @Override
    public List<ObraLiterariaDto> getTop5ObrasLiterarias() {
        Iterable<ObraLiteraria> obras = obraLiterariaRepository.findTop5ByOrderByCantidadDePaginasDesc();
        return StreamSupport.stream(obras.spliterator(), false)
                .map(obra -> modelMapper.map(obra, ObraLiterariaDto.class))
                .toList();
    }

    @Override
    public List<ObraLiterariaDto> getObrasLiterariasBeforeYear(int year) {
        Iterable<ObraLiteraria> obras = obraLiterariaRepository.findAllByAnioPrimeraPublicacionLessThan(year);
        return StreamSupport.stream(obras.spliterator(), false)
                .map(obra -> modelMapper.map(obra, ObraLiterariaDto.class))
                .toList();
    }

    @Override
    public List<ObraLiterariaDto> getObrasLiterariasByEditorial(String editorial) {
        Iterable<ObraLiteraria> obras = obraLiterariaRepository.findAllByEditorial(editorial);
        return StreamSupport.stream(obras.spliterator(), false)
                .map(obra -> modelMapper.map(obra, ObraLiterariaDto.class))
                .toList();
    }
}
