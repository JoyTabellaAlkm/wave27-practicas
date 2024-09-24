package com.bootcampW22.EjercicioGlobal.exception;

import java.util.List;

public class IncompleteVehicleDataException extends RuntimeException {
    public IncompleteVehicleDataException(List<String> errors) {
        super(String.join(", ", errors));
    }
}
