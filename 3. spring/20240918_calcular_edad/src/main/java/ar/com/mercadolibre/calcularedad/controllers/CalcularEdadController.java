package ar.com.mercadolibre.calcularedad.controllers;

import ar.com.mercadolibre.calcularedad.services.ICalcularEdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/calcular-edad")
public class CalcularEdadController {

    @Autowired
    ICalcularEdadService calcularEdadService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public ResponseEntity<?> calcularEdad(@PathVariable Integer dia,
                                       @PathVariable Integer mes,
                                       @PathVariable Integer anio) {
        HttpHeaders headers = new HttpHeaders();

        if(LocalDate.of(anio,mes,dia).isAfter( LocalDate.now()))
            { return new ResponseEntity<>("La fecha de nacimiento es una fecha futura", HttpStatus.BAD_REQUEST);}

        return ResponseEntity.ok(calcularEdadService.calcularEdad(dia, mes, anio));

    }



}
