package ar.com.mercadolibre.link.controller;

import ar.com.mercadolibre.link.model.dto.request.LinkRequestDTO;
import ar.com.mercadolibre.link.model.dto.response.LinkResponseDTO;
import ar.com.mercadolibre.link.service.ILinkService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkController {

    @Autowired
    ILinkService linkService;

    @PostMapping("/link/{url}")
    public ResponseEntity<?> saveURL(@RequestBody LinkRequestDTO link){

        return ResponseEntity.ok(linkService.saveLink(link));
    }


    @GetMapping("/link/{id}")
    public ResponseEntity<?> redirectLink(@PathVariable Integer id,
                                          @RequestParam (required = false) String password){

//        RedirectView redirectView = new RedirectView();
//        redirectView.setUrl("http://www.youtube.com");

        return ResponseEntity.ok(linkService.redirect(id, password));
    }


    @GetMapping("/metrics/{id}")
    public ResponseEntity<?> metricsById(@PathVariable Integer id){

        return ResponseEntity.ok(linkService.metricsById(id));
    }

    @PostMapping("/invalidate/{id}")
    public ResponseEntity<?> invalidateLink(@PathVariable Integer id){

        linkService.invalidateLink(id);

        return ResponseEntity.ok("Se invalido el link!");
    }
}
