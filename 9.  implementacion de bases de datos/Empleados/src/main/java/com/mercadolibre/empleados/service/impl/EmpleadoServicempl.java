package com.mercadolibre.empleados.service.impl;

import com.mercadolibre.empleados.dto.request.EmpleadoRequestDto;
import com.mercadolibre.empleados.dto.response.EmpleadoResponseDto;
import com.mercadolibre.empleados.enitity.Empleado;
import com.mercadolibre.empleados.repository.IEmpleadoRepository;
import com.mercadolibre.empleados.service.IEmpleadoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoServicempl implements IEmpleadoService {
@Autowired
IEmpleadoRepository repository;

ModelMapper mapper = new ModelMapper();

    @Override
    public EmpleadoResponseDto crearEmpleado(EmpleadoRequestDto empleadoRequestDto) {
        Empleado empleado = mapper.map(empleadoRequestDto, Empleado.class);
        repository.save(empleado);
        return mapper.map(empleado, EmpleadoResponseDto.class);
    }

    @Override
    public EmpleadoResponseDto actualizarEmpleado(String id, EmpleadoRequestDto empleadoRequestDto) {
        Empleado empleado = repository.findById(id).orElseThrow(()-> new RuntimeException("Empleado no encontrado"));
        empleado = mapper.map(empleadoRequestDto, Empleado.class);
        empleado.setId(id);
        repository.save(empleado);
        return mapper.map(empleado, EmpleadoResponseDto.class);
    }

    @Override
    public List<EmpleadoResponseDto> obtenerEmpleados() {
        List<EmpleadoResponseDto> empleados = new ArrayList<>();
        for(Empleado empleado : repository.findAll()) {
            empleados.add(mapper.map(empleado, EmpleadoResponseDto.class));
        }
        return empleados;
    }
}
