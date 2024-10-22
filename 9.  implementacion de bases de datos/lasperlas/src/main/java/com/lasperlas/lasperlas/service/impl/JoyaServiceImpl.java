package com.lasperlas.lasperlas.service.impl;

import com.lasperlas.lasperlas.dto.JoyaDTO;
import com.lasperlas.lasperlas.dto.response.JoyaCreatedDTO;
import com.lasperlas.lasperlas.entity.Joya;
import com.lasperlas.lasperlas.repository.IJoyaRepository;
import com.lasperlas.lasperlas.service.IJoyaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaServiceImpl implements IJoyaService {
    private final IJoyaRepository joyaRepository;
    private final ModelMapper modelMapper;

    public JoyaServiceImpl(IJoyaRepository joyaRepository, ModelMapper modelMapper) {
        this.joyaRepository = joyaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public JoyaCreatedDTO create(JoyaDTO joyaDTO) {
        Joya joya = joyaRepository.save(modelMapper.map(joyaDTO, Joya.class));

        return new JoyaCreatedDTO(joya.getId());
    }

    @Override
    public List<JoyaDTO> getAll() {
        List<JoyaDTO> jewels = joyaRepository.findAll().stream()
                .filter(Joya::isVentaONo)
                .map(joya -> modelMapper.map(joya, JoyaDTO.class))
                .toList();

        if (jewels.isEmpty()) {
            throw new RuntimeException("No jewels found");
        }

        return jewels;
    }

    @Override
    public String delete(Long id) {
        Joya joya = joyaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jewel not found"));

        if (!joya.isVentaONo()) {
            throw new RuntimeException("Jewel not in stock");
        }

        joyaRepository.deleteById(id);
        return "Jewel deleted";
    }

    @Override
    public JoyaDTO update(Long id, JoyaDTO joyaDTO) {
        Joya joya = joyaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jewel not found"));

        joya.setNombre(joyaDTO.getNombre());
        joya.setMaterial(joyaDTO.getMaterial());
        joya.setPeso(joyaDTO.getPeso());
        joya.setParticularidad(joyaDTO.getParticularidad());
        joya.setPoseePiedra(joyaDTO.getPoseePiedra());
        joya.setVentaONo(true);

        joyaRepository.save(joya);

        return modelMapper.map(joya, JoyaDTO.class);
    }
}
