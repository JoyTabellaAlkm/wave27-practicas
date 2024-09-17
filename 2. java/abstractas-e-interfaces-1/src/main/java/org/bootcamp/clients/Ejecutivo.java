package org.bootcamp.clients;

import org.bootcamp.transactions.Deposito;
import org.bootcamp.transactions.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {

    @Override
    public void depositar(double monto) {
        System.out.printf("Ejecutivo depositando $%s...%n", monto);
        ejecutarTransaccion("Depósito de $" + monto);
    }

    @Override
    public void transferir(double monto, String destinatario) {
        System.out.printf("Ejecutivo transfiriendo $%s a %s...%n", monto, destinatario);
        ejecutarTransaccion("Transferencia de $%s a %s".formatted(monto, destinatario));
    }

    @Override
    public void transaccionOk(String detalle) {
        System.out.println(detalle + " completado correctamente - Servicio ejecutivo");
    }

    @Override
    public void transaccionNoOk(String detalle) {
        System.out.println("Hubo un error ejecutando: " + detalle + " - Servicio ejecutivo");
    }
}
