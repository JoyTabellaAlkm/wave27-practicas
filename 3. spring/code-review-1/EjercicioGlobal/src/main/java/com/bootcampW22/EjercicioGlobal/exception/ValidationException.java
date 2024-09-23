package com.bootcampW22.EjercicioGlobal.exception;

import java.util.List;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(List<String> validationErrors) {
      StringBuilder errorString = new StringBuilder("The following validation errors were found:");
      validationErrors.forEach(error -> errorString.append("\n").append(error));
      throw new ValidationException(errorString.toString());
    }
}
