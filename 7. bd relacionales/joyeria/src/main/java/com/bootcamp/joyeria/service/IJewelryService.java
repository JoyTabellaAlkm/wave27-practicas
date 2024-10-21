package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dto.CreateJewelDto;
import com.bootcamp.joyeria.dto.CreatedJewelDto;
import com.bootcamp.joyeria.dto.JewelDto;

import java.util.List;

public interface IJewelryService {
    CreatedJewelDto createJewel(CreateJewelDto createJewelDto);

    List<JewelDto> getJewelry();

    void deleteJewel(Long id);

    JewelDto updateJewel(Long id, CreateJewelDto createJewelDto);
}
