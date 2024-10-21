package com.bootcamp.joyeria.service.impl;

import com.bootcamp.joyeria.dto.JewelDto;
import com.bootcamp.joyeria.exception.NotFoundException;
import com.bootcamp.joyeria.repository.JewelRepository;
import com.bootcamp.joyeria.dto.CreateJewelDto;
import com.bootcamp.joyeria.dto.CreatedJewelDto;
import com.bootcamp.joyeria.entity.Jewel;
import com.bootcamp.joyeria.service.IJewelryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelryServiceImpl implements IJewelryService {
    private final JewelRepository jewelRepository;
    private final ModelMapper modelMapper;

    public JewelryServiceImpl(JewelRepository jewelRepository, ModelMapper modelMapper) {
        this.jewelRepository = jewelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CreatedJewelDto createJewel(CreateJewelDto createJewelDto) {
        Jewel jewel = modelMapper.map(createJewelDto, Jewel.class);
        jewel.setVentaONo(true);
        jewel = jewelRepository.save(jewel);
        return new CreatedJewelDto(jewel.getId());
    }

    @Override
    public List<JewelDto> getJewelry() {
        List<Jewel> jewels = jewelRepository.findAllByVentaONoIsTrue();
        return jewels.stream()
                .map(jewel -> modelMapper.map(jewel, JewelDto.class))
                .toList();
    }

    @Override
    public void deleteJewel(Long id) {
        Jewel jewel = jewelRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Jewel not found"));
        jewel.setVentaONo(false);
        jewelRepository.save(jewel);
    }

    @Override
    public JewelDto updateJewel(Long id, CreateJewelDto createJewelDto) {
        Jewel jewel = jewelRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Jewel not found"));

        jewel.setNombre(createJewelDto.getNombre());
        jewel.setMaterial(createJewelDto.getMaterial());
        jewel.setParticularidad(createJewelDto.getParticularidad());
        jewel.setPesoEnGramos(createJewelDto.getPesoEnGramos());
        jewel.setPoseePiedra(createJewelDto.getPoseePiedra());

        jewel = jewelRepository.save(jewel);

        return modelMapper.map(jewel, JewelDto.class);
    }
}
