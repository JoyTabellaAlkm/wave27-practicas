package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        SocorristaAuto socorristaAuto = new SocorristaAuto();
        SocorristaMoto socorristaMoto = new SocorristaMoto();

        Carrera carrera = new Carrera(100.0, 5000.0, "Gran Carrera", 10, socorristaAuto, socorristaMoto);


        carrera.darDeAltaAuto(150.0, 10.0, 30.0, "ABC123");
        carrera.darDeAltaMoto(120.0, 8.0, 25.0, "XYZ789");


        carrera.socorrerAuto("ABC123");
        carrera.socorrerMoto("XYZ789");


        Vehiculo ganador = carrera.verGanador();
        if (ganador != null) {
            System.out.println("El ganador es el vehículo con patente: " + ganador.getPatente());
        } else {
            System.out.println("No hay vehículos en la carrera.");
        }
    }
}