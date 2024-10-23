package ar.com.mercadolibre.seguros.service;

import ar.com.mercadolibre.seguros.model.dto.request.ClaimRequestDTO;
import ar.com.mercadolibre.seguros.model.dto.response.ClaimResponseDTO;

import java.util.List;

public interface IClaimService {

    ClaimResponseDTO createClaim(ClaimRequestDTO claimRequestDTO);
    List<ClaimResponseDTO> getAllClaims();
}
