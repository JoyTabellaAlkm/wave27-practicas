package ar.com.mercadolibre.linktracker.controller;

import ar.com.mercadolibre.linktracker.dto.CreateLinkDto;
import ar.com.mercadolibre.linktracker.dto.ResponseDto;
import ar.com.mercadolibre.linktracker.service.LinkService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.UUID;

@RestController
public class LinkController {
    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/link")
    public ResponseEntity<?> createLink(@RequestBody CreateLinkDto link) {
        UUID linkId = linkService.create(link);
        return ResponseEntity.ok(new ResponseDto<>(linkId, 200));
    }

    @GetMapping("/link/{linkId}")
    public void goToLink(@PathVariable UUID linkId, @RequestParam String password, HttpServletResponse response) throws IOException {
        String url = linkService.getLinkUrl(linkId, password);
        response.sendRedirect(url);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> getMetrics(@PathVariable UUID linkId) {
        Integer redirections = linkService.getLinkRedirections(linkId);
        return ResponseEntity.ok(new ResponseDto<>(redirections, 200));
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidateLink(@PathVariable UUID linkId) {
        linkService.invalidateLink(linkId);
        return ResponseEntity.noContent().build();
    }
}
