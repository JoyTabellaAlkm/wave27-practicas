package co.com.mercadolibre.concesionariaautos.service;

import co.com.mercadolibre.concesionariaautos.dto.request.VehicleCreateRequestDTO;
import co.com.mercadolibre.concesionariaautos.dto.response.VehicleAllInfoResponseDTO;
import co.com.mercadolibre.concesionariaautos.dto.response.VehicleCreatedResponseDTO;
import co.com.mercadolibre.concesionariaautos.dto.response.VehicleResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface IVehicleService {
    VehicleCreatedResponseDTO createVehicle(VehicleCreateRequestDTO vehicle);

    List<VehicleResponseDTO> seeAllVehicles();

    List<VehicleResponseDTO> seeVehiclesByDate(LocalDate since, LocalDate to);

    List<VehicleResponseDTO> seeVehiclesByPrice(Double since, Double to);

    VehicleAllInfoResponseDTO seeAllInfoVehicle(Long id);
}
