package ar.com.mercadolibre.seguros.service.impl;

import ar.com.mercadolibre.seguros.model.Vehicle;
import ar.com.mercadolibre.seguros.model.dto.request.VehicleRequestDTO;
import ar.com.mercadolibre.seguros.model.dto.response.VehicleLicensePlateBrandResponseDTO;
import ar.com.mercadolibre.seguros.model.dto.response.VehiclePlateBrandModelResponseDTO;
import ar.com.mercadolibre.seguros.model.dto.response.VehicleResponseDTO;
import ar.com.mercadolibre.seguros.repository.VehicleRepository;
import ar.com.mercadolibre.seguros.service.IVehicleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleService implements IVehicleService {

    private final VehicleRepository repository;
    private final ModelMapper modelMapper;

    public VehicleResponseDTO createVehicle(VehicleRequestDTO vehicle) {
        Vehicle saved = repository.save(modelMapper.map(vehicle, Vehicle.class));
        return modelMapper.map(saved, VehicleResponseDTO.class);
    }

    @Override
    public List<VehicleResponseDTO> getAll() {
        return repository.findAll().stream()
                .map(vehicle -> modelMapper.map(vehicle, VehicleResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllLicensePlates(){
        return repository.getAllLicensePlates();
    }

    @Override
    public List<VehicleLicensePlateBrandResponseDTO> getVehicleSortedByYear() {
        return repository.getVehicleSortedByYear().stream()
                .map(vehicle -> new VehicleLicensePlateBrandResponseDTO(vehicle[0].toString(), vehicle[1].toString()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getPlatesWheelsAndYear() {
        return repository.getLicensePlateWheelsAndYear();
    }

    @Override
    public List<VehiclePlateBrandModelResponseDTO> getPlateBrandModelByAmountClaim(Double amount) {
        return repository.getLicenseBrandModelByAmountOfClaim(amount).stream()
                .map(vehicle -> new VehiclePlateBrandModelResponseDTO(vehicle[0].toString(), vehicle[1].toString(), vehicle[2].toString()))
                .collect(Collectors.toList());
    }
}
