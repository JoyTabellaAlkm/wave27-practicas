package co.mercadolibre.deportistas.controllador;

import co.mercadolibre.deportistas.entity.Deporte;
import co.mercadolibre.deportistas.service.IDeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportistasControllador {

    @Autowired
    IDeporteService iDeporteService;

    @GetMapping("/findSports")
    public ResponseEntity<?> getListaDeporte(){
        return new ResponseEntity<>(iDeporteService.getDeporte(),HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> getListaDeportesByName(@PathVariable String name){
        return new ResponseEntity<>(iDeporteService.getListaDeportesByName(name), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> getListaDeportistas(){
        return new ResponseEntity<>(iDeporteService.getListaDeportesDeportistas(), HttpStatus.OK);
    }
}
