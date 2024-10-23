package com.mercadolibre.joyeria.controllers;

import com.mercadolibre.joyeria.dtos.requests.RequestJoyaDTO;
import com.mercadolibre.joyeria.dtos.requests.RequestUpdateJoyaDTO;
import com.mercadolibre.joyeria.services.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jewerly")
public class JoyaController {

    @Autowired
    IJoyaService joyaService;

    @PostMapping("/new")
    public ResponseEntity<?> crearJoya(@RequestBody RequestJoyaDTO requestJoyaDTO){
        return new ResponseEntity<>(joyaService.crearJoya(requestJoyaDTO), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?>mostrarJoyas(){
        return new ResponseEntity<>(joyaService.mostrarJoyas(),HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> eliminarJoyaResgistrada(@PathVariable Integer id){
        return new ResponseEntity<>(joyaService.eliminarJoyaResgistrada(id),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?>mostrarTodo(){
        return new ResponseEntity<>(joyaService.mostrarTodo(),HttpStatus.OK);
    }

    @PutMapping("/update/{idModificar}")
    public ResponseEntity<?> actualizarJoya(@PathVariable Integer idModificar, @RequestBody RequestUpdateJoyaDTO requestJoyaDTO){
        return new ResponseEntity<>(joyaService.actualizarParticularidadJoya(idModificar,requestJoyaDTO),HttpStatus.OK);
    }

}
