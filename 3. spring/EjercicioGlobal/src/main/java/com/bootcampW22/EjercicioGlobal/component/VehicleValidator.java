package com.bootcampW22.EjercicioGlobal.component;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VehicleValidator {
    private static final int MAX_SPEED = 413;

    public List<String> validateVehicle(VehicleDto vehicleDto) {
        List<String> errors = new ArrayList<>();

        if (vehicleDto.getId() == null) {
            errors.add("El ID no puede ser nulo");
        }

        if (isNullOrEmpty(vehicleDto.getBrand())) {
            errors.add("La marca no puede estar vacía");
        }

        if (isNullOrEmpty(vehicleDto.getModel())) {
            errors.add("El modelo no puede estar vacío");
        }

        if (isNullOrEmpty(vehicleDto.getRegistration())) {
            errors.add("El registro no puede estar vacío");
        }

        if (vehicleDto.getYear() <= 0 ||  vehicleDto.getYear() > LocalDate.now().getYear()) {
            errors.add("El año no puede ser menor que 1 ni mayor al año actual");
        }

        if (isNullOrEmpty(vehicleDto.getColor())) {
            errors.add("El color no puede estar vacío");
        }

        if (vehicleDto.getMax_speed().isEmpty()) {
            errors.add("La velocidad máxima no puede ser nula");
        }

        if (isNullOrEmpty(vehicleDto.getFuel_type())) {
            errors.add("El tipo de combustible no puede estar vacío");
        }

        if (isNullOrEmpty(vehicleDto.getTransmission())) {
            errors.add("El tipo de transmisión no puede estar vacío");
        }

        if (vehicleDto.getPassengers() <= 0) {
            errors.add("El número de pasajeros no puede ser menor que 1");
        }

        if (vehicleDto.getHeight() <= 0) {
            errors.add("La altura no puede ser menor que 1");
        }

        if (vehicleDto.getWidth() <= 0) {
            errors.add("El ancho no puede ser menor que 1");
        }

        if (vehicleDto.getWeight() <= 0) {
            errors.add("El peso no puede ser menor que 1");
        }

        return errors;
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public boolean validateSpeed(String speed) {
        Integer intSpeed = Integer.parseInt(speed);

        if (intSpeed <= 0 || intSpeed >= MAX_SPEED) {
            return false;
        }

        return true;
    }

    public boolean validateFuel(String type) {
        return !isNullOrEmpty(type);
    }
}
