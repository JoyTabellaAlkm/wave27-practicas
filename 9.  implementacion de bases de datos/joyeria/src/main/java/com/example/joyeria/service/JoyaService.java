package com.example.joyeria.service;

import com.example.joyeria.dto.request.JoyaCreateDto;
import com.example.joyeria.dto.response.JoyaDto;
import com.example.joyeria.dto.response.JoyaListDto;
import com.example.joyeria.dto.response.JoyaSimpleDto;
import com.example.joyeria.model.Joya;
import com.example.joyeria.repository.IJoyaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JoyaService implements IJoyaService{

    private final IJoyaRepository iJoyaRepository;
    ObjectMapper objectMapper = new ObjectMapper();

    public JoyaService(IJoyaRepository iJoyaRepository) {
        this.iJoyaRepository = iJoyaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Joya findJoya(long nroIdentificatorio) {
        return iJoyaRepository.findById(nroIdentificatorio).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public JoyaListDto getJoyas() {
        List<JoyaDto> joyaDtoList = iJoyaRepository.findAll().stream()
                .map(j->objectMapper.convertValue(j, JoyaDto.class))
                .toList();
        return new JoyaListDto(joyaDtoList);
    }

    @Override
    @Transactional
    public JoyaSimpleDto saveJoya(JoyaCreateDto joyaCreateDto) {
        Joya joya = objectMapper.convertValue(joyaCreateDto, Joya.class);
        iJoyaRepository.save(joya);
        return new JoyaSimpleDto("Joya guardada: "+joya.getNombre()+", correctamente");
    }

    @Override
    @Transactional
    public JoyaSimpleDto editarJoya(long nro_identificatorio, String nombre, String material ,int peso, String particularidad, boolean poseePiedra, boolean ventaONo) {

        Joya joya = findJoya(nro_identificatorio);

        joya.setNombre(nombre);
        joya.setMaterial(material);
        joya.setPeso(peso);
        joya.setParticularidad(particularidad);
        joya.setPoseePiedra(poseePiedra);
        joya.setVentaONo(ventaONo);
        iJoyaRepository.save(joya);

        return new JoyaSimpleDto("Joya modificada: "+joya.getNombre()+", correctamente");
    }

    @Override
    public JoyaSimpleDto deleteJoya(long nroIdentificatorio) {
        iJoyaRepository.deleteById(nroIdentificatorio);
        return new JoyaSimpleDto("Joya con numero : "+nroIdentificatorio+", eliminada correctamente");
    }

}
