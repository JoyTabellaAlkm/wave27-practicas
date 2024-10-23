package ar.com.mercadolibre.elastic.controller;


import ar.com.mercadolibre.elastic.model.Empleado;
import ar.com.mercadolibre.elastic.service.IEmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado")
@RequiredArgsConstructor
public class EmpleadoController {


    private final IEmpleadoService service;

    @PostMapping
    public ResponseEntity<Empleado> save(@RequestBody Empleado empleado){
        return ResponseEntity.ok(service.save(empleado));
    }

    @GetMapping
    public ResponseEntity<List<Empleado>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getById(@PathVariable Integer id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping
    public ResponseEntity<Empleado> uodate(@RequestBody Empleado empleado){
        return ResponseEntity.ok(service.save(empleado));
    }

}
