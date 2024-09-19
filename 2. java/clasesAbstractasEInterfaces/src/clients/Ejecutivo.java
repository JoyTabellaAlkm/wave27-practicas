package clients;

import transactions.Deposito;
import transactions.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {
    @Override
    public void realizarDeposito() {
        System.out.println("Ejecutivo realiza deposito");
    }

    @Override
    public void transaccionOk() {

    }

    @Override
    public void transaccionNoOk() {

    }

    @Override
    public void realizarTransferencia() {
        System.out.println(getClass().getSimpleName() + " realiza transferencia");
    }
}
