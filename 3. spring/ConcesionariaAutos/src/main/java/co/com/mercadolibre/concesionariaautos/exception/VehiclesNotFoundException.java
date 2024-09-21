package co.com.mercadolibre.concesionariaautos.exception;

public class VehiclesNotFoundException extends RuntimeException {
    public VehiclesNotFoundException(String message) {
        super(message);
    }
}
