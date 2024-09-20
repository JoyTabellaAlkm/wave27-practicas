package org.linktracker.controllers;

import org.linktracker.dtos.CreateLinkDTO;
import org.linktracker.exceptions.LinkIsInvalid;
import org.linktracker.exceptions.LinkNeedsAuthorization;
import org.linktracker.exceptions.LinkNotFound;
import org.linktracker.services.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URI;
import java.util.UUID;

@RestController
public class LinkController {
    @Autowired
    private ILinkService linkService;

    @PostMapping("new")
    public UUID createLink(@RequestBody CreateLinkDTO dto) throws LinkIsInvalid {
        return linkService.createLink(dto);
    }

    @GetMapping("link/{id}")
    public RedirectView getLink(@PathVariable UUID id, @RequestParam(required = false) String password) throws LinkNotFound, LinkNeedsAuthorization {
        URI uri = linkService.getLink(id, password);
        String path = uri.toString();
        return new RedirectView(path);
    }

    @GetMapping("metrics/{id}")
    public Integer getLinkMetrics(@PathVariable UUID id, @RequestParam(required = false) String password) throws LinkNotFound, LinkNeedsAuthorization {
        return linkService.getLinkMetrics(id, password);
    }

    @PostMapping("invalidate/{id}")
    public void invalidateLink(@PathVariable UUID id, @RequestParam(required = false) String password) throws LinkNotFound, LinkNeedsAuthorization {
        linkService.invalidateLink(id, password);
    }

    @ExceptionHandler(LinkNotFound.class)
    public ResponseEntity<String> handleLinkNotFound(LinkNotFound linkNotFound) {
        return new ResponseEntity<>(linkNotFound.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LinkIsInvalid.class)
    public ResponseEntity<String> handleLinkIsInvalid(LinkIsInvalid linkIsInvalid) {
        return new ResponseEntity<>(linkIsInvalid.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LinkNeedsAuthorization.class)
    public ResponseEntity<String> handleLinkIsInvalid(LinkNeedsAuthorization linkNeedsAuthorization) {
        return new ResponseEntity<>(linkNeedsAuthorization.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
