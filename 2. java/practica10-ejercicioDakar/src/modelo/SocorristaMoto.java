package modelo;

public class SocorristaMoto extends Socorrista{

    @Override
    public void socorrer(Vehiculo vehiculo){
        if (vehiculo instanceof Auto) throw new RuntimeException("No puedo socorrer autos");
        String mensaje = String.format("Socorriendo moto: %s", vehiculo.getPatente());
        System.out.println(mensaje);
    }
}
