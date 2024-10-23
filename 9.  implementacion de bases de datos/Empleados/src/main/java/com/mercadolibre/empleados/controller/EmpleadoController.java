package com.mercadolibre.empleados.controller;

import com.mercadolibre.empleados.dto.request.EmpleadoRequestDto;
import com.mercadolibre.empleados.service.IEmpleadoService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    @Autowired
    IEmpleadoService service;

    @PostMapping("/crear" )
    public ResponseEntity<?> crearEmpleado(@RequestBody EmpleadoRequestDto empleadoRequestDto) {
        return new ResponseEntity<>(service.crearEmpleado(empleadoRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarEmpleado(@PathVariable String id, @RequestBody EmpleadoRequestDto empleadoRequestDto) {
        return new ResponseEntity<>(service.actualizarEmpleado(id, empleadoRequestDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> obtenerEmpleados() {
        return new ResponseEntity<>(service.obtenerEmpleados(), HttpStatus.OK);
    }

}
