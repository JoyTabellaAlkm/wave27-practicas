package banco.clientes;

import banco.transacciones.ConsultaSaldo;
import banco.transacciones.RetiroEfectivo;

public class Cobrador implements RetiroEfectivo, ConsultaSaldo {
    static String nombre = "Cobrador";

    public Cobrador() {
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Cliente: " + nombre + ", Consultando Saldo...");
        System.out.println("\n");
    }

    @Override
    public void retiroEfectivo() {
        System.out.println("Cliente: " + nombre + ", Retirando efectivo...");
        System.out.println("\n");
    }

    @Override
    public void transaccionOk() {

    }

    @Override
    public void transaccionNoOk() {

    }
}
