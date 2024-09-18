import model.Auto;
import model.Carrera;
import model.Moto;
import model.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Carrera carrera = new Carrera(50, 10000, "Tokyo Drift", 5);
        carrera.darDeAltaAuto(100, 70, 60, "CK4HYFH");
        carrera.darDeAltaAuto(140, 100, 70, "C449GKD");
        carrera.darDeAltaMoto(190, 80, 45, "SL49FJ3");
        carrera.darDeAltaMoto(110, 50, 45, "SMOO402");
        carrera.darDeAltaMoto(160, 100, 60, "S5993EK");


        carrera.socorrerAuto("CK4HYFH");
        carrera.socorrerMoto("S5993EK");

        carrera.definirGanador();

    }
}