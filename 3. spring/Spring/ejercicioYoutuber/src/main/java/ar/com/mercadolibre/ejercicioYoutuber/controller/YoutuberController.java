package ar.com.mercadolibre.ejercicioYoutuber.controller;

import ar.com.mercadolibre.ejercicioYoutuber.dto.BlogDTO;
import ar.com.mercadolibre.ejercicioYoutuber.entity.EntradaBlog;
import ar.com.mercadolibre.ejercicioYoutuber.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class YoutuberController {

    private final IService iService;

    @Autowired
    public YoutuberController(IService iService){
        this.iService = iService;
    }

    @PostMapping("/blog")
    public ResponseEntity<?> createEntradaBlog(@RequestBody BlogDTO entradaBlog){
        return new ResponseEntity<>(iService.createEntradaBlog(entradaBlog), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        return new ResponseEntity<>(iService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> getAllEntradaBlog(){
        return new ResponseEntity<>(iService.getAll(), HttpStatus.OK);
    }
}
