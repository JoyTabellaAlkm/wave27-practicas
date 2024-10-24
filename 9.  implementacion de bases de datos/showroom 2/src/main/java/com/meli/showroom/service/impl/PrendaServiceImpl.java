package com.meli.showroom.service.impl;

import com.meli.showroom.dto.request.PrendaRequestDto;
import com.meli.showroom.dto.response.PrendaResponseDto;
import com.meli.showroom.dto.response.ResponseDto;
import com.meli.showroom.domain.Prenda;
import com.meli.showroom.exception.NotFoundException;
import com.meli.showroom.repository.IPrendaRepository;
import com.meli.showroom.service.IPrendaService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrendaServiceImpl implements IPrendaService {
    private final IPrendaRepository prendaRepository;
    private ModelMapper mapper = new ModelMapper();

    public PrendaServiceImpl(IPrendaRepository prendaRepository) {
        this.prendaRepository = prendaRepository;
    }

    @Override
    public PrendaResponseDto nuevaPrenda(PrendaRequestDto prendaRequestDto) {
        Prenda prenda = mapper.map(prendaRequestDto, Prenda.class);
        prenda.setCodigo(null);
        prendaRepository.save(prenda);
        return mapper.map(prenda, PrendaResponseDto.class);
    }

    @Override
    public List<PrendaResponseDto> listarPrendas(String name) {
        if(name == null){
            return prendaRepository.findAll(PageRequest.of(0, 10)).stream()
                    .map(prenda -> mapper.map(prenda, PrendaResponseDto.class)).toList();
        }
        return prendaRepository.findByNombreContaining(name).stream()
                .map(prenda -> mapper.map(prenda, PrendaResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PrendaResponseDto devolverPrenda(String code) {
        Prenda prenda = this.findPrendaById(code);
        return mapper.map(prenda, PrendaResponseDto.class);
    }

    @Override
    public PrendaResponseDto actualizarPrenda(String code, PrendaRequestDto prendaResponseDto) {
        this.findPrendaById(code);
        Prenda prenda = mapper.map(prendaResponseDto, Prenda.class);
        prenda.setCodigo(code);
        prenda = prendaRepository.save(prenda);
        return mapper.map(prenda, PrendaResponseDto.class);
    }

    @Override
    public ResponseDto eliminarPrenda(String code) {
        Prenda prenda = this.findPrendaById(code);
        prendaRepository.delete(prenda);
        return new ResponseDto("Prenda número %s eliminada correctamente".formatted(code), HttpStatus.OK);
    }

    @Override
    public List<PrendaResponseDto> listarPrendasPorTalla(String size) {
        return prendaRepository.findAllByTalla(size).stream()
                .map(prenda -> mapper.map(prenda, PrendaResponseDto.class))
                .collect(Collectors.toList());
    }

    private Prenda findPrendaById(String code){
        return prendaRepository.findById(code).orElseThrow(()-> new NotFoundException("No se encontró la prenda código: %s".formatted(code)));
    }
}
