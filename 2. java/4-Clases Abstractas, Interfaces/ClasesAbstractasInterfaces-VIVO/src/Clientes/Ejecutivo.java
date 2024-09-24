package Clientes;

import Transacciones.ITransaccionConsultaSaldo;
import Transacciones.ITransaccionDeposito;
import Transacciones.ITransaccionRetiroEfectivo;
import Transacciones.ITransaccionTransferencia;

public class Ejecutivo implements ITransaccionDeposito, ITransaccionTransferencia {

    @Override
    public void transaccionOK() {
        System.out.println("Transacción OK");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("Transacción NO OK");
    }

    @Override
    public void depositar() {
        System.out.println("Depositar");
    }

    @Override
    public void transferir() {
        System.out.println("Transferir");
    }
}
