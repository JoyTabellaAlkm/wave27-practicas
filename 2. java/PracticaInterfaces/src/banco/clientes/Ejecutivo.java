package banco.clientes;

import banco.transacciones.Deposito;
import banco.transacciones.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {

    static String nombre = "Ejecutivo";

    @Override
    public void transaccionOk() {

    }

    @Override
    public void transaccionNoOk() {

    }

    @Override
    public void realizarDeposito() {
        System.out.println("Cliente: " + nombre + ", Realizando Deposito...");
        System.out.println("\n");
    }

    @Override
    public void realizarTransferencia() {
        System.out.println("Cliente: " + nombre + ", Realizando Transferencia...");
        System.out.println("\n");
    }
}
