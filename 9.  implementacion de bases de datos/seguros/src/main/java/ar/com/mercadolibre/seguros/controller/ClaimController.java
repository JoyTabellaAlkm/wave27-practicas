package ar.com.mercadolibre.seguros.controller;


import ar.com.mercadolibre.seguros.model.dto.request.ClaimRequestDTO;
import ar.com.mercadolibre.seguros.model.dto.response.ClaimResponseDTO;
import ar.com.mercadolibre.seguros.service.IClaimService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/claim")
@RequiredArgsConstructor
public class ClaimController {

    private final IClaimService service;

    @PostMapping
    public ResponseEntity<ClaimResponseDTO> createClaim(@RequestBody ClaimRequestDTO claimRequestDTO) {
        ClaimResponseDTO createdClaim = service.createClaim(claimRequestDTO);
        return ResponseEntity.ok(createdClaim);
    }

    @GetMapping
    public ResponseEntity<List<ClaimResponseDTO>> getAllClaims(){
        return ResponseEntity.ok(service.getAllClaims());
    }
}
