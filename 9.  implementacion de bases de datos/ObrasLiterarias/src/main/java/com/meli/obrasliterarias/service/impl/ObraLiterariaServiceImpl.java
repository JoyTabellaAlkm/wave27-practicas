package com.meli.obrasliterarias.service.impl;

import com.meli.obrasliterarias.dto.ObraLiterariaDto;
import com.meli.obrasliterarias.dto.ResponseDto;
import com.meli.obrasliterarias.model.ObraLiteraria;
import com.meli.obrasliterarias.repository.IObrasLiterariasRepository;
import com.meli.obrasliterarias.service.IObraLiterariaService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraLiterariaServiceImpl implements IObraLiterariaService {
    private final IObrasLiterariasRepository obrasLiterariasRepository;
    private ModelMapper mapper;

    public ObraLiterariaServiceImpl(IObrasLiterariasRepository obrasLiterariasRepository) {
        this.obrasLiterariasRepository = obrasLiterariasRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public ResponseDto createBook(ObraLiterariaDto obraLiteraria) {
        ObraLiteraria obra = mapper.map(obraLiteraria, ObraLiteraria.class);
        obrasLiterariasRepository.save(obra);
        return new ResponseDto("Creado correctamente", HttpStatus.OK);
    }

    @Override
    public List<ObraLiterariaDto> findByAutor(String autor) {
        return obrasLiterariasRepository.findByAutor(autor).stream()
                .map(obra -> mapper.map(obra, ObraLiterariaDto.class))
                .toList();
    }

    @Override
    public List<ObraLiterariaDto> findByWordInTitle(String word) {
        return obrasLiterariasRepository.findByTituloContaining(word).stream()
                .map(obra -> mapper.map(obra, ObraLiterariaDto.class))
                .toList();
    }

    @Override
    public List<ObraLiterariaDto> topFiveByPages() {
        return obrasLiterariasRepository.findTop5ByOrderByCantidadPaginasDesc().stream()
                .map(obra -> mapper.map(obra, ObraLiterariaDto.class))
                .toList();
    }

    @Override
    public List<ObraLiterariaDto> findByYear(String year) {
        return obrasLiterariasRepository.findByAnioPublicacionBefore(year).stream()
                .map(obra -> mapper.map(obra, ObraLiterariaDto.class))
                .toList();
    }

    @Override
    public List<ObraLiterariaDto> findByEditorial(String editorial) {
        return obrasLiterariasRepository.findByEditorial(editorial).stream()
                .map(obra -> mapper.map(obra, ObraLiterariaDto.class))
                .toList();
    }
}
