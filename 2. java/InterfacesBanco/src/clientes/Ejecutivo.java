package clientes;

import transacciones.IDeposito;
import transacciones.ITransferencia;

public class Ejecutivo implements IDeposito, ITransferencia {
    @Override
    public void transaccionOk() {
        System.out.println("Transacción de cliente ejecutivo ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion de cliente ejecutivo fallida");
    }

    @Override
    public void realizarDeposito() {
        System.out.println("Realizando deposito por cliente ejecutivo");
    }

    @Override
    public void realizarTransaccion() {
        System.out.println("Realizando transacción por cliente ejecutivo");
    }
}
