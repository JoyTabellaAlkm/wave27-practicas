package modelo;

public class Auto extends Vehiculo{

    public Auto(double velocidad, int aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 1000, 4);
    }
}
