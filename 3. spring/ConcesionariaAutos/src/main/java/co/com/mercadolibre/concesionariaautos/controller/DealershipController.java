package co.com.mercadolibre.concesionariaautos.controller;

import co.com.mercadolibre.concesionariaautos.dto.request.VehicleCreateRequestDTO;
import co.com.mercadolibre.concesionariaautos.dto.response.VehicleAllInfoResponseDTO;
import co.com.mercadolibre.concesionariaautos.dto.response.VehicleCreatedResponseDTO;
import co.com.mercadolibre.concesionariaautos.dto.response.VehicleResponseDTO;
import co.com.mercadolibre.concesionariaautos.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class DealershipController {

    @Autowired
    IVehicleService vehicleService;

    @PostMapping("/")
    public ResponseEntity<?> createVehicle(@RequestBody VehicleCreateRequestDTO vehicleRequest){
        VehicleCreatedResponseDTO vehicleCreatedResponseDTO = vehicleService.createVehicle(vehicleRequest);
        return new ResponseEntity<>(vehicleCreatedResponseDTO, HttpStatus.CREATED);

    }
    @GetMapping("/")
    public ResponseEntity<?> seeAllVehicles(){
        List<VehicleResponseDTO> vehicleResponseDTOList = vehicleService.seeAllVehicles();
        return new ResponseEntity<>(vehicleResponseDTOList,HttpStatus.OK);
    }
    @GetMapping("/dates")
    public ResponseEntity<?> seeVehiclesByDate(@RequestParam LocalDate since, @RequestParam LocalDate to){
        List<VehicleResponseDTO> vehicleResponseDTOList = vehicleService.seeVehiclesByDate(since,to);
        return new ResponseEntity<>(vehicleResponseDTOList,HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<?> seeVehiclesByPrice(@RequestParam Double since, @RequestParam Double to){
        List<VehicleResponseDTO> vehicleResponseDTOList = vehicleService.seeVehiclesByPrice(since,to);
        return new ResponseEntity<>(vehicleResponseDTOList,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> seeAllInfoVehicle(@PathVariable Long id){
        VehicleAllInfoResponseDTO vehicle = vehicleService.seeAllInfoVehicle(id);
        return new ResponseEntity<>(vehicle,HttpStatus.OK);
    }
}
