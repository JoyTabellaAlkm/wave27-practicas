package com.meli.showroom.service.impl;

import com.meli.showroom.dto.PrendaRequestDto;
import com.meli.showroom.dto.PrendaResponseDto;
import com.meli.showroom.dto.ResponseDto;
import com.meli.showroom.dto.VentaResponseDto;
import com.meli.showroom.entity.Prenda;
import com.meli.showroom.entity.Venta;
import com.meli.showroom.exception.NotFoundException;
import com.meli.showroom.repository.IPrendaRepository;
import com.meli.showroom.service.IPrendaService;
import org.modelmapper.ModelMapper;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrendaServiceImpl implements IPrendaService {
    private final IPrendaRepository prendaRepository;
    private final PageableHandlerMethodArgumentResolver pageableResolver;
    private ModelMapper mapper = new ModelMapper();

    public PrendaServiceImpl(IPrendaRepository prendaRepository, PageableHandlerMethodArgumentResolver pageableResolver) {
        this.prendaRepository = prendaRepository;
        this.pageableResolver = pageableResolver;
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
            return prendaRepository.findAll().stream()
                    .map(prenda -> mapper.map(prenda, PrendaResponseDto.class)).toList();
        }
        return prendaRepository.findByNombreContaining(name).stream()
                .map(prenda -> mapper.map(prenda, PrendaResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PrendaResponseDto devolverPrenda(Long code) {
        Prenda prenda = this.findPrendaById(code);
        return mapper.map(prenda, PrendaResponseDto.class);
    }

    @Override
    public PrendaResponseDto actualizarPrenda(Long code, PrendaRequestDto prendaResponseDto) {
        this.findPrendaById(code);
        Prenda prenda = mapper.map(prendaResponseDto, Prenda.class);
        prenda.setCodigo(code);
        prenda = prendaRepository.save(prenda);
        return mapper.map(prenda, PrendaResponseDto.class);
    }

    @Override
    public ResponseDto eliminarPrenda(Long code) {
        Prenda prenda = this.findPrendaById(code);
        prendaRepository.delete(prenda);
        return new ResponseDto("Prenda número %d eliminada correctamente".formatted(code), HttpStatus.OK);
    }

    @Override
    public List<PrendaResponseDto> listarPrendasPorTalla(String size) {
        return prendaRepository.findAllByTalla(size).stream()
                .map(prenda -> mapper.map(prenda, PrendaResponseDto.class))
                .collect(Collectors.toList());
    }

    private Prenda findPrendaById(Long code){
        return prendaRepository.findById(code).orElseThrow(()-> new NotFoundException("No se encontró la prenda código: %d".formatted(code)));
    }
}
