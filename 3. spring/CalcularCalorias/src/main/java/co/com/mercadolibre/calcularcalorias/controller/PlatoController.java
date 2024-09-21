package co.com.mercadolibre.calcularcalorias.controller;

import co.com.mercadolibre.calcularcalorias.dto.request.PlatoDTORequest;
import co.com.mercadolibre.calcularcalorias.dto.response.PlatoDTOResponse;
import co.com.mercadolibre.calcularcalorias.service.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlatoController {
@Autowired
    IPlatoService platoService;
    @GetMapping("/plato")
    public ResponseEntity<?> verPlato(@RequestParam String nombre, @RequestParam Integer peso){
        PlatoDTOResponse platoDTOResponse = platoService.verPlato(nombre,peso);
        return new ResponseEntity<>(platoDTOResponse, HttpStatus.OK);
    }

    @GetMapping("/platos")
    public ResponseEntity<?> verPlato(@RequestBody List<PlatoDTORequest> platosDTO){
        List<PlatoDTOResponse> platosDTOResponse = platoService.verPlatos(platosDTO);
        return new ResponseEntity<>(platosDTOResponse, HttpStatus.OK);
    }
}
