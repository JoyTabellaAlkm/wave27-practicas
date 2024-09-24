package ar.com.mercadolibre.ejercicioLink.controller;

import ar.com.mercadolibre.ejercicioLink.dto.CreateLinkDTO;
import ar.com.mercadolibre.ejercicioLink.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api")
public class LinkController {

    @Autowired
    private final IService iService;

    @Autowired
    public LinkController(IService iService){
        this.iService = iService;
    }

    @PostMapping
    public ResponseEntity<?> createLink(@RequestBody CreateLinkDTO createLinkDTO){
        return new ResponseEntity<>(iService.crearLink(createLinkDTO), HttpStatus.CREATED);
    }

    @GetMapping("/redirect/{id}")
    public RedirectView getRedirection(@PathVariable Integer id){
        return new RedirectView(iService.getUrl(id));
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<?> getStadistics(@PathVariable Integer id){
        return new ResponseEntity<>(iService.obtenerEstadistica(id),HttpStatus.OK);
    }

    @PostMapping("/invalid/{id}")
    public ResponseEntity<?> invalidLink(@PathVariable Integer id){
        return new ResponseEntity<>(iService.invalidLink(id),HttpStatus.NOT_FOUND);
    }

}
