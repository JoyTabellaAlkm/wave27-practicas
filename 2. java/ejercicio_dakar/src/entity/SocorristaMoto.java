package entity;

public class SocorristaMoto implements Socorrista {
    @Override
    public void socorrer(Vehiculo vehiculo) {
        System.out.println("Socorriendo entity.Moto: " + vehiculo.getPatente());
    }
}
