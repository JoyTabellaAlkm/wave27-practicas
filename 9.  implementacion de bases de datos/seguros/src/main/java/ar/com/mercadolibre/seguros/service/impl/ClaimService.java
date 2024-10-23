package ar.com.mercadolibre.seguros.service.impl;

import ar.com.mercadolibre.seguros.exception.NotFoundException;
import ar.com.mercadolibre.seguros.model.Claim;
import ar.com.mercadolibre.seguros.model.Vehicle;
import ar.com.mercadolibre.seguros.model.dto.request.ClaimRequestDTO;
import ar.com.mercadolibre.seguros.model.dto.response.ClaimResponseDTO;
import ar.com.mercadolibre.seguros.repository.ClaimRepository;
import ar.com.mercadolibre.seguros.repository.VehicleRepository;
import ar.com.mercadolibre.seguros.service.IClaimService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClaimService implements IClaimService {

    private final ClaimRepository repository;
    private final VehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;


    public ClaimResponseDTO createClaim(ClaimRequestDTO claimRequestDTO) {
        Vehicle vehicle = vehicleRepository.findById(claimRequestDTO.getVehicleId())
                .orElseThrow(() -> new NotFoundException("Vehicle not found"));

        Claim claim = modelMapper.map(claimRequestDTO, Claim.class);
        claim.setVehicle(vehicle);
        claim.setId(null);

        Claim savedClaim = repository.save(claim);
        return modelMapper.map(savedClaim, ClaimResponseDTO.class);
    }

    @Override
    public List<ClaimResponseDTO> getAllClaims() {
        return repository.findAll().stream()
                .map(claim -> modelMapper.map(claim, ClaimResponseDTO.class))
                .collect(Collectors.toList());
    }


}
