package ar.com.mercadolibre.joyeria.controller;

import ar.com.mercadolibre.joyeria.dto.JoyaDto;
import ar.com.mercadolibre.joyeria.service.IJoyeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewerly")
public class Controller {
    @Autowired
    private IJoyeriaService joyaServ;

    @PostMapping("/new")
    public ResponseEntity<?> createJewel(@RequestBody JoyaDto jewelDto){//deberia tener dtos
        return ResponseEntity.ok(joyaServ.saveJewel(jewelDto));
    }

    @GetMapping("")
    public ResponseEntity<?> getJewel(){
        return ResponseEntity.ok(joyaServ.getJewel());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getJewelById(@PathVariable Long id){
        return ResponseEntity.ok(joyaServ.findJewel(id));
    }

    @PutMapping ("/delete/{id}")
    public ResponseEntity<?> deleteJJewel (@PathVariable Long id) {
        return ResponseEntity.ok(joyaServ.deleteJewel(id));
    }

    @PutMapping ("/update/{id}")
    public String editJewel (@PathVariable Long id,
                            @RequestBody JoyaDto jewelDto) {
        return joyaServ.editJewel(id, jewelDto);
    }
 }
