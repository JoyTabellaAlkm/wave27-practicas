import entity.Auto;
import entity.Carrera;
import entity.Moto;
import entity.Vehiculo;

public class Main {
    public static void main(String[] args) {
        Auto auto1 = new Auto(120, 50.5, 40, "ABC");
        Moto moto1 = new Moto(80, 30, 80, "DRF");
        Carrera carrera = new Carrera(5, 10000, "La mortal", 3);

        carrera.darDeAltaMoto(moto1.getVelocidad(), moto1.getAceleracion(), moto1.getAnguloDeGiro(), moto1.getPatente());
        carrera.darDeAltaAuto(auto1.getVelocidad(), auto1.getAceleracion(), auto1.getAnguloDeGiro(), auto1.getPatente());
        System.out.println(carrera);

        System.out.println("Se elimina un auto");
        //carrera.eliminarVehiculo(auto1);
        System.out.println(carrera);

        Vehiculo vehiculoGanador = carrera.ganador();
        System.out.println("El vehiculo ganador es: "+vehiculoGanador);
    }
}
