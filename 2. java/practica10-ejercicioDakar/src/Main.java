import modelo.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Socorrista> listaSocorrista = new ArrayList<>();

        SocorristaAuto socorristaAuto = new SocorristaAuto();
        SocorristaMoto socorristaMoto = new SocorristaMoto();

        listaSocorrista.add(socorristaAuto);
        listaSocorrista.add(socorristaMoto);

        Carrera carrera = new Carrera(80.0, 1000, "Dakar", 3, listaSocorrista);

        carrera.darDeAltaAuto(120.0, 2, 40, "Ford");
        carrera.darDeAltaMoto(120.0, 6, 60, "Ninja");

        System.out.println("El ganador es: "+carrera.obtenerGanador().getPatente());

        carrera.socorrerAuto("Ford");
        carrera.socorrerMoto("Ninja");
    }
}