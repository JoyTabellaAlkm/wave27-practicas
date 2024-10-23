package ar.com.mercadolibre.seguros.service;

import ar.com.mercadolibre.seguros.model.Vehicle;
import ar.com.mercadolibre.seguros.model.dto.request.VehicleRequestDTO;
import ar.com.mercadolibre.seguros.model.dto.response.VehicleLicensePlateBrandResponseDTO;
import ar.com.mercadolibre.seguros.model.dto.response.VehiclePlateBrandModelResponseDTO;
import ar.com.mercadolibre.seguros.model.dto.response.VehicleResponseDTO;

import java.util.List;

public interface IVehicleService {

    VehicleResponseDTO createVehicle(VehicleRequestDTO vehicle);
    List<VehicleResponseDTO> getAll();
    List<String> getAllLicensePlates();
    List<VehicleLicensePlateBrandResponseDTO> getVehicleSortedByYear();
    List<String> getPlatesWheelsAndYear();
    List<VehiclePlateBrandModelResponseDTO> getPlateBrandModelByAmountClaim(Double amount);
}
