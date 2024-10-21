package com.example.joyeria.controller;

import com.example.joyeria.dto.request.JoyaCreateDto;
import com.example.joyeria.dto.response.JoyaDto;
import com.example.joyeria.model.Joya;
import com.example.joyeria.service.IJoyaService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JoyaController {

    @Autowired
    private IJoyaService iJoyaService;

    @PostMapping("/crear")
    public ResponseEntity<?> crearJoya(@RequestBody JoyaCreateDto joyaCreateDto){
        return new ResponseEntity<>(iJoyaService.saveJoya(joyaCreateDto), HttpStatus.CREATED);
    }

    @PostMapping("/modificar/{nro_identificatorio}")
    public ResponseEntity<?> modificarJoya(@PathVariable long nro_identificatorio,
                                       @RequestParam("nombre") String nombre,
                                       @RequestParam("material") String material,
                                       @RequestParam("peso") int peso,
                                       @RequestParam("particularidad") String particularidad,
                                       @RequestParam("posee_piedra") boolean poseePiedra,
                                       @RequestParam("venta_o_no") boolean ventaONo
                                       ){

        return new ResponseEntity<>(iJoyaService.editarJoya(nro_identificatorio, nombre, material, peso, particularidad,poseePiedra,ventaONo), HttpStatus.OK);
    }

    @GetMapping("/joyas")
    public ResponseEntity<?> crearJoya(){
        return new ResponseEntity<>(iJoyaService.getJoyas(), HttpStatus.OK);
    }

    @PostMapping("/borrar/{nro_identificatorio}")
    public ResponseEntity<?> borrarJoya(@PathVariable long nro_identificatorio){
        return new ResponseEntity<>(iJoyaService.deleteJoya(nro_identificatorio), HttpStatus.OK);
    }

}
