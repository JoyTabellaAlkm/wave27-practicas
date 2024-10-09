package modelo;

public class Socorrista {

    public void socorrer(Vehiculo vehiculo){
        String mensaje = String.format("Socorriendo: %s", vehiculo.getPatente());
        System.out.println(mensaje);
    }
}
