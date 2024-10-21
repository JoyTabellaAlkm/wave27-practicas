package com.meli.joyerialasperlas.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.joyerialasperlas.dto.JewelRequestDto;
import com.meli.joyerialasperlas.dto.JewelResponseDto;
import com.meli.joyerialasperlas.dto.ResponseDto;
import com.meli.joyerialasperlas.exception.NotFoundException;
import com.meli.joyerialasperlas.model.Jewel;
import com.meli.joyerialasperlas.repository.JewelRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IJewelServiceImpl implements IJewelService {

    private final JewelRepository jewelRepository;
    private ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);

    public IJewelServiceImpl(JewelRepository joyaRepository){
        this.jewelRepository=joyaRepository;
    }

    @Override
    public ResponseDto newJewel(JewelRequestDto newJeweldto) {
        Jewel newJewel = mapper.convertValue(newJeweldto, Jewel.class);
        newJewel.setVentaONo(true);
        Jewel createdJewel = jewelRepository.save(newJewel);
        return new ResponseDto("nro identificatorio: %d".formatted(createdJewel.getNroIdentificatorio()), HttpStatus.OK);
    }

    @Override
    public List<JewelResponseDto> listJewelry() {
        return jewelRepository.findAll().stream()
                .filter(jewel -> jewel.getVentaONo().equals(true))
                .map(jewel -> mapper.convertValue(jewel, JewelResponseDto.class))
                .toList();
    }

    @Override
    public ResponseDto deleteJewel(Long id) {
        Jewel jewel = jewelRepository.findById(id).orElseThrow(()->new NotFoundException("No se encontró la joya con id: %d".formatted(id)));
        jewel.setVentaONo(false);
        jewelRepository.save(jewel);
        return new ResponseDto("Eliminado correctamente", HttpStatus.OK);
    }

    @Override
    public JewelResponseDto updateJewel(Long id, JewelRequestDto newJewelDto) {
        Jewel jewel = jewelRepository.findById(id).orElseThrow(()->new NotFoundException("No se encontró la joya con id: %d".formatted(id)));
        jewel.setNombre(newJewelDto.getNombre());
        jewel.setMaterial(newJewelDto.getMaterial());
        jewel.setPeso(newJewelDto.getPeso());
        jewel.setParticularidad(newJewelDto.getParticularidad());
        jewel.setPoseePiedra(newJewelDto.getPoseePiedra());
        jewelRepository.save(jewel);
        return mapper.convertValue(jewel, JewelResponseDto.class);
    }
}
