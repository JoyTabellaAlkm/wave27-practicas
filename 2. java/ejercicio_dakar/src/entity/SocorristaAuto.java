package entity;

public class SocorristaAuto implements Socorrista {
    @Override
    public void socorrer(Vehiculo vehiculo) {
        System.out.println("Socorriendo entity.Auto: " + vehiculo.getPatente());
    }
}
