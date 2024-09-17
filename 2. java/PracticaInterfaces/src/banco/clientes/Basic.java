package banco.clientes;

import banco.transacciones.ConsultaSaldo;
import banco.transacciones.PagoServicios;
import banco.transacciones.RetiroEfectivo;

public class Basic implements ConsultaSaldo, PagoServicios, RetiroEfectivo {
    static String nombre = "Basico";

    public Basic() {
    }

    @Override
    public void transaccionOk() {}

    @Override
    public void transaccionNoOk() {}

    @Override
    public void retiroEfectivo() {
        System.out.println("Cliente: " + nombre + ", Retirando Efectivo...");
        System.out.println("\n");
    }

    @Override
    public void pagandoServicios() {
        System.out.println("Cliente: " + nombre + ", Pagando servicios...");
        System.out.println("\n");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Cliente: " + nombre +  ", Consultando Saldo...");
        System.out.println("\n");
    }
}
