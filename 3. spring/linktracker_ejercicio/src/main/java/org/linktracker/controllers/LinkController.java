package org.linktracker.controllers;

import org.linktracker.dtos.CreateLinkRequestDTO;
import org.linktracker.dtos.CreateLinkResponseDTO;
import org.linktracker.exceptions.LinkIsInvalid;
import org.linktracker.exceptions.LinkNeedsAuthorization;
import org.linktracker.exceptions.LinkNotFound;
import org.linktracker.services.ILinkService;
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
    private ILinkService linkService;

    @PostMapping("new")
    public CreateLinkResponseDTO createLink(@RequestBody CreateLinkRequestDTO dto) throws LinkIsInvalid {
        return linkService.createLink(dto);
    }

    @GetMapping("link/{id}")
    public ResponseEntity<?> getLink(@PathVariable String id, @RequestParam(required = false) String password) throws LinkNotFound, LinkNeedsAuthorization {
        URI uri = linkService.getLink(id, password);
        String path = uri.toString();
        //return new RedirectView(path); //Esto tambien redirige
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", path);
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }

    @GetMapping("metrics/{id}")
    public Integer getLinkMetrics(@PathVariable String id, @RequestParam(required = false) String password) throws LinkNotFound, LinkNeedsAuthorization {
        return linkService.getLinkMetrics(id, password);
    }

    @PostMapping("invalidate/{id}")
    public void invalidateLink(@PathVariable String id, @RequestParam(required = false) String password) throws LinkNeedsAuthorization, LinkNotFound {
        linkService.invalidateLink(id, password);
    }
}
