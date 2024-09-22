package ar.com.linktracker.demo.controllers;

import ar.com.linktracker.demo.dtos.CreateLinkDTO;
import ar.com.linktracker.demo.dtos.CreateLinkRequestDTO;
import ar.com.linktracker.demo.services.ILinkServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/")
public class LinkController {
    @Autowired
    private ILinkServices linkService;

    @PostMapping("new")
    public CreateLinkDTO createLink(@RequestBody CreateLinkRequestDTO dto){
        return linkService.createLink(dto);
    }

    @GetMapping("link/{id}")
    public ResponseEntity<?> getLink(@PathVariable String id, @RequestParam(required = false) String password){
        URI uri = linkService.getLink(id, password);
        String path = uri.toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", path);
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }

    @GetMapping("metrics/{id}")
    public Integer getLinkMetrics(@PathVariable String id, @RequestParam(required = false) String password){
        return linkService.getLinkMetrics(id, password);
    }

    @PostMapping("invalidate/{id}")
    public void invalidateLink(@PathVariable String id, @RequestParam(required = false) String password){
        linkService.invalidateLink(id, password);
    }
}