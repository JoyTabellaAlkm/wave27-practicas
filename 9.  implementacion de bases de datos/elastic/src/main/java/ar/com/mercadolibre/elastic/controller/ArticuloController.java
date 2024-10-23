package ar.com.mercadolibre.elastic.controller;

import ar.com.mercadolibre.elastic.model.Articulo;
import ar.com.mercadolibre.elastic.service.IArticuloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/articulo")
@RequiredArgsConstructor
public class ArticuloController {

    private final IArticuloService service;

    @PostMapping
    public Articulo createArticulo(@RequestBody Articulo articulo) {
        return service.save(articulo);
    }

    @GetMapping("/{id}")
    public Optional<Articulo> getArticuloById(@PathVariable int id) {
        return service.findById(id);
    }

    @GetMapping
    public Iterable<Articulo> getAllArticulos() {
        return service.findAll();
    }

    @PutMapping("/{id}")
    public Articulo updateArticulo(@PathVariable Integer id, @RequestBody Articulo articulo) {
        articulo.setId(id);
        return service.save(articulo);
    }

    @DeleteMapping("/{id}")
    public void deleteArticulo(@PathVariable int id) {
        service.deleteById(id);
    }

}
