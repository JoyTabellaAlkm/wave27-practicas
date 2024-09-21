package co.com.mercadolibre.concesionariaautos.repository;

import co.com.mercadolibre.concesionariaautos.dto.request.VehicleCreateRequestDTO;
import co.com.mercadolibre.concesionariaautos.dto.response.VehicleResponseDTO;
import co.com.mercadolibre.concesionariaautos.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    Vehicle createVehicle(VehicleCreateRequestDTO vehicle);

    List<Vehicle> seeAllVehicles();
}
