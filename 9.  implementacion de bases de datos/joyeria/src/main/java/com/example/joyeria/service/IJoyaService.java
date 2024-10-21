package com.example.joyeria.service;

import com.example.joyeria.dto.request.JoyaCreateDto;
import com.example.joyeria.dto.response.JoyaDto;
import com.example.joyeria.dto.response.JoyaListDto;
import com.example.joyeria.dto.response.JoyaSimpleDto;
import com.example.joyeria.model.Joya;
import jakarta.persistence.Column;

import java.util.List;

public interface IJoyaService {
    public Joya findJoya(long nroIdentificatorio);
    public JoyaListDto getJoyas();
    public JoyaSimpleDto saveJoya(JoyaCreateDto joya);
    public JoyaSimpleDto editarJoya(long nroIdentificatorio, String nombre, String material ,int peso, String particularidad, boolean poseePiedra, boolean ventaONo);
    public JoyaSimpleDto deleteJoya(long nroIdentificatorio);
}
