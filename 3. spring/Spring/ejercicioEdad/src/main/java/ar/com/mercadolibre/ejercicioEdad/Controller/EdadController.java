package ar.com.mercadolibre.ejercicioEdad.Controller;

import ar.com.mercadolibre.ejercicioEdad.Exception.ExceptionParametros;
import ar.com.mercadolibre.ejercicioEdad.Service.IEdad;
import org.intellij.lang.annotations.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@Validated
public class EdadController {
    @Autowired
    IEdad iEdad;

    @GetMapping("/{dia}/{mes}/{anio}")
    public ResponseEntity<Integer> devolverEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
        int diaInput = String.valueOf(dia).length();
        int mesInput = String.valueOf(mes).length();
        int anioInput = String.valueOf(anio).length();
        if(diaInput < 2 || mesInput < 2 || anioInput < 4){
            throw new ExceptionParametros("Cantidad de numeros ingresados incorrecto");
        }
        if((dia < 0 || dia > 31) || (mes < 0 || mes > 12) || anio < 0){
            throw new IllegalArgumentException("Rango de fecha inválido");
        }
        return ResponseEntity.ok(iEdad.devolverEdad(dia, mes, anio));
    }

}
