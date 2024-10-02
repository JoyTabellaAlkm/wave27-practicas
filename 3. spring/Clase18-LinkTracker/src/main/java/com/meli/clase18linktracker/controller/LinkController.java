package com.meli.clase18linktracker.controller;

import com.meli.clase18linktracker.dto.request.NewLinkDTO;
import com.meli.clase18linktracker.exception.InvalidLinkException;
import com.meli.clase18linktracker.exception.LinkNeedsAuthorization;
import com.meli.clase18linktracker.exception.LinkNotFoundException;
import com.meli.clase18linktracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
public class LinkController {
    @Autowired
    ILinkService linkService;

    @PostMapping("/createLink")
    public ResponseEntity<?> createLink(@RequestBody NewLinkDTO newLinkDTO) throws InvalidLinkException {
        return new ResponseEntity<>(linkService.createLink(newLinkDTO), HttpStatus.CREATED);
    }

    @GetMapping("/link/{id}")
    public ResponseEntity<?> getLink(@PathVariable String id, @RequestParam(required = false) String password) throws LinkNotFoundException, LinkNeedsAuthorization {
        URI uri = linkService.getLink(id, password);
        String path = uri.toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", path);
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<?> showMetrics(@PathVariable String id, @RequestParam(required = false) String password){
        return new ResponseEntity<>(linkService.showMetrics(id, password), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{id}")
    public void invalidateLink(@PathVariable String id, @RequestParam(required = false) String password) throws  LinkNotFoundException, LinkNeedsAuthorization{
        linkService.invalidateLink(id, password);
    }
}
