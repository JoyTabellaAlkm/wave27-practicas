package ar.com.mercadolibre.lasperlas.controller;

import ar.com.mercadolibre.lasperlas.entity.Joya;
import ar.com.mercadolibre.lasperlas.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class JoyaController {

    @Autowired
    private IJoyaService joyaService;

    @PostMapping("/jewerly/new")
    public ResponseEntity<?> createJoya(@RequestBody Joya joya){
        return new ResponseEntity<>(joyaService.saveJoya(joya), HttpStatus.CREATED);
    }

    @GetMapping("/jewerly")
    public  ResponseEntity<?> getJoyas(){
        return new ResponseEntity<>(joyaService.getJoyas(), HttpStatus.OK);
    }

    @PostMapping("/jewerly/update/{id_modificar}")
    public ResponseEntity<?> editJoya (@PathVariable Long id_modificar,
                                       @RequestParam String nombre,
                                       @RequestParam  String material,
                                       @RequestParam Double peso,
                                       @RequestParam String particularidad,
                                       @RequestParam Boolean poseePiedra){
        Joya joya = joyaService.findJoya(id_modificar);
        joya.setNombre(nombre);
        joya.setMaterial(material);
        joya.setPeso(peso);
        joya.setParticularidad(particularidad);
        joya.setPoseePiedra(poseePiedra);
        return new ResponseEntity<>(joyaService.saveJoya(joya), HttpStatus.OK);
    }

    @DeleteMapping("/jewerly/delete/{id}")
    public ResponseEntity<?> deleteJoya(Long id){
        Joya joya = joyaService.findJoya(id);
        joya.setVentaONo(false);
        return new ResponseEntity<>(joya, HttpStatus.OK);
    }
}
