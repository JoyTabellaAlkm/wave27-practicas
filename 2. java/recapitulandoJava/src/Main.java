import Garage.Garage;
import vehiculo.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> coches = new ArrayList<>();

        coches.add(new Vehiculo("Ford", "Fiesta", 1000));
        coches.add(new Vehiculo("Ford", "Focus", 1200));
        coches.add(new Vehiculo("Ford", "Explorer", 2500));
        coches.add(new Vehiculo("Fiat", "Uno", 500));
        coches.add(new Vehiculo("Fiat", "Cronos", 1000));
        coches.add(new Vehiculo("Fiat", "Torino", 1250));
        coches.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        coches.add(new Vehiculo("Chevrolet", "Spin", 2500));
        coches.add(new Vehiculo("Toyota", "Corola", 1200));
        coches.add(new Vehiculo("Toyota", "Fortuner", 3000));
        coches.add(new Vehiculo("Renault", "Logan", 950));

        Garage garage = new Garage(1);
        garage.agregarVehiculos(coches);
        garage.imprimirListaVehiculosPorMarcaYPreccio();
        System.out.println("####---------------####");
        garage.imprimirVehiculosConCostoMenorA1000();
        System.out.println("####---------------####");
        garage.imprimirVehiculosConCostoMayorA1000();
        System.out.println("####---------------####");
        garage.imprimirPromedioTotal();
    }
}