package com.bootcampW22.EjercicioGlobal.utils;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class VehicleValidatorImpl implements VehicleValidator{
    public void validate(VehicleDto vehicle) {
        if (
                vehicle.getId() == null || vehicle.getId() < 0
                || isStringInvalid(vehicle.getBrand())
                || isStringInvalid(vehicle.getModel())
                || isStringInvalid(vehicle.getRegistration())
                || isStringInvalid(vehicle.getColor())
                || vehicle.getYear() < 1886 || vehicle.getYear() > LocalDate.now().getYear()
                || isStringInvalid(vehicle.getMax_speed()) || Double.parseDouble(vehicle.getMax_speed()) < 0
                || vehicle.getPassengers() < 1
                || isFuelInvalid(vehicle.getFuel_type())
                || isStringInvalid(vehicle.getTransmission())
                || vehicle.getHeight() < 0
                || vehicle.getWidth() < 0
                || vehicle.getWeight() < 0
        ) {
            throw new ValidationException("Datos del vehículo mal formados o incompletos.");
        }
    }

    private boolean isStringInvalid(String string) {
        return string == null || string.isBlank();
    }

    private boolean isFuelInvalid(String fuelType) {
        List<String> validFuelTypes = List.of("gasoline", "diesel", "gas", "biodiesel");
        return isStringInvalid(fuelType) || !validFuelTypes.contains(fuelType.toLowerCase());
    }
}
