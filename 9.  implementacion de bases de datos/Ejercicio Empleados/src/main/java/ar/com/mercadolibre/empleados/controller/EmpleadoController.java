package ar.com.mercadolibre.empleados.controller;

import ar.com.mercadolibre.empleados.entity.Empleado;
import ar.com.mercadolibre.empleados.service.IEmpleadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    private final IEmpleadoService empleadoService;

    public EmpleadoController(IEmpleadoService empleadoService){this.empleadoService = empleadoService; }

    @PostMapping("/new")
    public ResponseEntity<?> guardarEmpleado(@RequestBody Empleado empleado){
        return ResponseEntity.ok(empleadoService.save(empleado));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> modificarEmpleado(@PathVariable Long id, @RequestBody Empleado empleado){
        return ResponseEntity.ok(empleadoService.modificarEmpleado(id, empleado));
    }

}

