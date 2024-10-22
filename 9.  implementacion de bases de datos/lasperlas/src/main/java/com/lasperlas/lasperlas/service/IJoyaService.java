package com.lasperlas.lasperlas.service;

import com.lasperlas.lasperlas.dto.JoyaDTO;
import com.lasperlas.lasperlas.dto.response.JoyaCreatedDTO;

import java.util.List;

public interface IJoyaService {
    JoyaCreatedDTO create(JoyaDTO joyaDTO);
    List<JoyaDTO> getAll();
    String delete(Long id);
    JoyaDTO update(Long id, JoyaDTO joyaDTO);
}
