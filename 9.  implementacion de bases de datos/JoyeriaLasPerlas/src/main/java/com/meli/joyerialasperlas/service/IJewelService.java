package com.meli.joyerialasperlas.service;

import com.meli.joyerialasperlas.dto.JewelRequestDto;
import com.meli.joyerialasperlas.dto.JewelResponseDto;
import com.meli.joyerialasperlas.dto.ResponseDto;

import java.util.List;

public interface IJewelService {
    ResponseDto newJewel(JewelRequestDto newJewel);
    List<JewelResponseDto> listJewelry();
    ResponseDto deleteJewel(Long id);
    JewelResponseDto updateJewel(Long id, JewelRequestDto newJewel);
}
