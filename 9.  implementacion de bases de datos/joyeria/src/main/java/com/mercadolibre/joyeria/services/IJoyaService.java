package com.mercadolibre.joyeria.services;

import com.mercadolibre.joyeria.dtos.JoyaDTO;
import com.mercadolibre.joyeria.dtos.requests.RequestJoyaDTO;
import com.mercadolibre.joyeria.dtos.requests.RequestUpdateJoyaDTO;
import com.mercadolibre.joyeria.dtos.responses.ResponseJoyaDTO;
import com.mercadolibre.joyeria.dtos.responses.ResponseUpdateJoyaDTO;

import java.util.List;

public interface IJoyaService {

    ResponseJoyaDTO crearJoya(RequestJoyaDTO requestJoyaDTO);

    List<JoyaDTO> mostrarJoyas();

    ResponseJoyaDTO eliminarJoyaResgistrada(Integer id);

    List<JoyaDTO> mostrarTodo();

    ResponseUpdateJoyaDTO actualizarParticularidadJoya(Integer idModificar, RequestUpdateJoyaDTO requestJoyaDTO);
}
