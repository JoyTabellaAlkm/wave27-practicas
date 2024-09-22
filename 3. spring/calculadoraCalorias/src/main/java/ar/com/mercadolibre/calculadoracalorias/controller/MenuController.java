package ar.com.mercadolibre.calculadoracalorias.controller;

import ar.com.mercadolibre.calculadoracalorias.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    IMenuService menuService;

    @GetMapping
    public ResponseEntity<?> findMenu() {
        return ResponseEntity.ok(menuService.findMenu());
    }

    @GetMapping("/{name}/{weigth}")
    public ResponseEntity<?> findPlate(@PathVariable String name, @PathVariable Integer weigth) {
        return ResponseEntity.ok(menuService.findPlate(name, weigth));
    }
}
