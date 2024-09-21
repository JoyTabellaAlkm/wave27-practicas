package co.com.mercadolibre.concesionariaautos.exception;

import co.com.mercadolibre.concesionariaautos.dto.response.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnableToCreateVehicleException.class)
    public ResponseEntity<?> handlerUnableToCreateVehicleException(UnableToCreateVehicleException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDTO(e.getMessage(), 400));
    }


    @ExceptionHandler(VehiclesNotFoundException.class)
    public ResponseEntity<?> handlerUnableToCreateVehicleException(VehiclesNotFoundException e){
        return ResponseEntity.status(HttpStatus.OK).body(new ExceptionDTO(e.getMessage(), 200));
    }
}
