package ar.com.mercadolibre.ejercicioEdad.controller;

import ar.com.mercadolibre.ejercicioEdad.exception.ExceptionParametros;
import ar.com.mercadolibre.ejercicioEdad.service.IEdad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EdadController {
    @Autowired
    IEdad iEdad;

    @GetMapping("/{dia}/{mes}/{anio}")
    public ResponseEntity<Integer> devolverEdad(@PathVariable String dia, @PathVariable String mes, @PathVariable String anio){
        int diaInput = Integer.parseInt(dia);
        int mesInput = Integer.parseInt(mes);
        int anioInput = Integer.parseInt(anio);
        if(dia.length() < 2 || mes.length() < 2 || anio.length() < 4){
            throw new ExceptionParametros("Cantidad de numeros ingresados incorrecto");
        }
        if((diaInput< 0 || diaInput> 31) || (mesInput  < 0 || mesInput  > 12) || anioInput  < 0){
            throw new ExceptionParametros("Rango de fecha inválido");
        }
        return new ResponseEntity<Integer>(iEdad.devolverEdad(diaInput, mesInput , anioInput ), HttpStatus.OK);
    }

}
