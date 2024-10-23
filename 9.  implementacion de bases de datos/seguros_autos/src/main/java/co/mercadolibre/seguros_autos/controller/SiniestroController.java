package co.mercadolibre.seguros_autos.controller;

import co.mercadolibre.seguros_autos.dto.request.SiniestroRequestDTO;
import co.mercadolibre.seguros_autos.dto.response.PatenteMarcaModeloDTO;
import co.mercadolibre.seguros_autos.service.ISiniestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/siniestros")
public class SiniestroController {

    @Autowired
    private ISiniestroService service;

    @PostMapping("/new")
    public ResponseEntity<?> createSinistro(@RequestBody SiniestroRequestDTO siniestroRequestDTO){
        return new ResponseEntity<>(service.createSiniestro(siniestroRequestDTO), HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public ResponseEntity<?> findAllSiniestro(){
        return new ResponseEntity<>(service.findAllSiniestro(), HttpStatus.OK);
    }

    @GetMapping("/listLostOverTenThousand")
    public ResponseEntity<?> listSiniestrosLostOverTenThousand(){
        return new ResponseEntity<>(service.getVehiculosByPerdidaEconomicaAbove10000(), HttpStatus.OK);
    }

    @GetMapping("/listLostOverTenThousandAndSum")
    public ResponseEntity<?> listSiniestrosLostOverTenThousandAndSum(){
        return new ResponseEntity<>(service.getVehiculosByPerdidaEconomicaAbove10000Agrupada(), HttpStatus.OK);
    }

}
