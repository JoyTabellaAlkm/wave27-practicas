package com.w27.practicaresponseentity.controller;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HolaMundoController {
    @GetMapping
    ResponseEntity<String> holaMundo(){
        return new ResponseEntity<>("Hola!!!", HttpStatus.OK);
    }

    @GetMapping({"/verificar/{correo}"})
    ResponseEntity<String> verificarCorreo(@PathVariable String correo){
        if (!EmailValidator.getInstance().isValid(correo)){
            return new ResponseEntity<String>("Formato debe ser: ejemplo@correo.dominio", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("Su correo es: " + correo, HttpStatus.OK);
    }

    @GetMapping("/cabecera/{cliente}")
    ResponseEntity<String> cabeceraPersonalizada(@PathVariable String cliente){
        HttpHeaders cabecera = new HttpHeaders();
        cabecera.add("Estado cliente", "Cliente" + cliente + "habilitado");

        return new ResponseEntity<>("Bienvenido " + cliente, cabecera, HttpStatus.OK);
    }

    @GetMapping("/cabeceraCustomizada/{cliente}")
    ResponseEntity<String> cabeceraCustomizada(@PathVariable String cliente){
        return ResponseEntity.ok().header("Estado Cliente", "Cliente " + cliente +": habilitado" ).body("Bienvenido cliente "+ cliente);
    }


}
