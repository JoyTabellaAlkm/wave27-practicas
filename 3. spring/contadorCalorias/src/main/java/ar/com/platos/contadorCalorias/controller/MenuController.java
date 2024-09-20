package ar.com.platos.contadorCalorias.controller;

import ar.com.platos.contadorCalorias.service.impl.CalculadoraDeCalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private CalculadoraDeCalService calculadoraDeCalService;

    @GetMapping("/plato/{nombre}")
    public ResponseEntity<?> infoDelPlato(@PathVariable String nombre) {
        return  ResponseEntity.ok(calculadoraDeCalService.mostrarInfoDePlato(nombre));
    }

}
