package modelo;

public class SocorristaAuto extends Socorrista{

    @Override
    public void socorrer(Vehiculo vehiculo) {
        if (vehiculo instanceof Moto) throw new RuntimeException("No puedo socorrer motos");
        String mensaje = String.format("Socorriendo auto: %s", vehiculo.getPatente());
        System.out.println(mensaje);
    }
}
