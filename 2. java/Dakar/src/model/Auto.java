package model;

public class Auto extends  Vehiculo{

    public Auto() {

    }

    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 1000, 4);
    }
}
