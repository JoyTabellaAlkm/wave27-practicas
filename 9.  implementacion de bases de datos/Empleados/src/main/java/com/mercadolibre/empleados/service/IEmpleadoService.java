package com.mercadolibre.empleados.service;

import com.mercadolibre.empleados.dto.request.EmpleadoRequestDto;
import com.mercadolibre.empleados.dto.response.EmpleadoResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEmpleadoService {
    EmpleadoResponseDto crearEmpleado(EmpleadoRequestDto empleadoRequestDto);

    EmpleadoResponseDto actualizarEmpleado(String id, EmpleadoRequestDto empleadoRequestDto);

    List<EmpleadoResponseDto> obtenerEmpleados();
}
