package com.mercadolibre.joyeria.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.joyeria.dto.request.JoyaRequestDto;
import com.mercadolibre.joyeria.dto.response.IdJoyaResponseDTO;
import com.mercadolibre.joyeria.dto.response.JoyaResponseDTO;
import com.mercadolibre.joyeria.dto.response.ResponseDTO;
import com.mercadolibre.joyeria.enitity.Joya;
import com.mercadolibre.joyeria.repository.IJoyaRepository;
import com.mercadolibre.joyeria.service.IJoyaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaServiceImpl implements IJoyaService {


@Autowired
    IJoyaRepository repository;

    @Override
    @Transactional
    public IdJoyaResponseDTO createJoya(JoyaRequestDto joyaDto) {
        Joya joya = new Joya();
        joya.setNombre(joyaDto.getNombre());
        joya.setMaterial(joyaDto.getMaterial());
        joya.setPeso(joyaDto.getPeso());
        joya.setParticularidad(joyaDto.getParticularidad());
        joya.setPoseePiedra(joyaDto.getPoseePiedra());
        try{
        Joya joyaResponse = repository.save(joya);
        return new IdJoyaResponseDTO(joyaResponse.getNroIdentificatorio());
        }catch (Exception e)
        {
            throw new RuntimeException("No se pudo crear la joya.");
        }

    }

    @Override
    public List<JoyaResponseDTO> getAll() {
        List <Joya> listaJoyas = repository.findAll();

        return listaJoyas.stream()
                .filter(joya -> joya.getVentaONo() != null && joya.getVentaONo())
                .map(joya ->
                new JoyaResponseDTO(
                        joya.getNroIdentificatorio(),
                        joya.getNombre(),
                        joya.getMaterial(),
                        joya.getPeso(),
                        joya.getParticularidad(),
                        joya.getPoseePiedra(),
                        joya.getVentaONo()
                ))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ResponseDTO deleteJoya(Long id) {
        Joya joya = repository.findById(id).orElse(null);
        if(joya ==null){
            throw new RuntimeException("Joya no encontrada.");
        }
        joya.setVentaONo(false);
        repository.save(joya);
        return new ResponseDTO("Joya eliminada correctamente.");
    }

    @Override
    @Transactional
    public JoyaResponseDTO updateJoya(Long id, JoyaRequestDto joyaDto) {
        Joya joya = repository.findById(id).orElse(null);
        if(joya ==null){
            throw new RuntimeException("Joya no encontrada.");
        }
        joya.setNombre(joyaDto.getNombre());
        joya.setMaterial(joyaDto.getMaterial());
        joya.setPeso(joyaDto.getPeso());
        joya.setParticularidad(joyaDto.getParticularidad());
        joya.setPoseePiedra(joyaDto.getPoseePiedra());
        try{
            Joya joyaResponse = repository.save(joya);

            JoyaResponseDTO joyaResponseDTO  = new JoyaResponseDTO();
            joyaResponseDTO.setNroIdentificatorio(joya.getNroIdentificatorio());
            joyaResponseDTO.setNombre(joya.getNombre());
            joyaResponseDTO.setMaterial(joya.getMaterial());
            joyaResponseDTO.setPeso(joya.getPeso());
            joyaResponseDTO.setParticularidad(joya.getParticularidad());
            joyaResponseDTO.setPoseePiedra(joya.getPoseePiedra());
            return joyaResponseDTO;
        }catch (Exception e)
        {
            throw new RuntimeException("No se pudo crear la joya.");
        }
    }

}
