package co.com.mercadolibre.concesionariaautos.repository.impl;

import co.com.mercadolibre.concesionariaautos.dto.request.VehicleCreateRequestDTO;
import co.com.mercadolibre.concesionariaautos.dto.response.VehicleResponseDTO;
import co.com.mercadolibre.concesionariaautos.entity.Service;
import co.com.mercadolibre.concesionariaautos.entity.Vehicle;
import co.com.mercadolibre.concesionariaautos.repository.IVehicleRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository {
    List<Vehicle> vehicleList = new ArrayList<>();
    Long id = 1L;
    Long idService = 1L;

    @Override
    public Vehicle createVehicle(VehicleCreateRequestDTO vehicleRequest) {
        List<Service> serviceList = new ArrayList<>();
        serviceList.addAll(vehicleRequest.getServices());
        for(Service service : serviceList){
            service.setId(idService++);
        }

        Vehicle vehicle = new Vehicle(id++,vehicleRequest.getBrand(),vehicleRequest.getModel(),
                vehicleRequest.getManufacturingDate(),vehicleRequest.getNumberOfKilometers(),
                vehicleRequest.getDoors(),vehicleRequest.getPrice(),vehicleRequest.getCurrency(),
                serviceList,vehicleRequest.getCountOfOwners());
        vehicleList.add(vehicle);
        return vehicle;
    }

    @Override
    public List<Vehicle> seeAllVehicles() {

        return vehicleList;
    }
}
