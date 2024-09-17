package org.bootcamp.clients;

import org.bootcamp.transactions.ConsultaDeSaldo;
import org.bootcamp.transactions.RetiroDeEfectivo;
import org.bootcamp.transactions.Transaccion;

public class Cobrador implements RetiroDeEfectivo, ConsultaDeSaldo, Transaccion {
    @Override
    public void consultar() {
        System.out.println("Cobrador consultando saldo...");
        ejecutarTransaccion("Consulta de saldo");
    }

    @Override
    public void retirarEfectivo(double monto) {
        System.out.printf("Cobrador retirando %s...%n", monto);
        ejecutarTransaccion("Retiro de $%s".formatted(monto));
    }

    @Override
    public void transaccionOk(String detalle) {
        System.out.println(detalle + " completado correctamente - Servicio cobrador");
    }

    @Override
    public void transaccionNoOk(String detalle) {
        System.out.println("Hubo un error ejecutando: " + detalle + " - Servicio cobrador");
    }
}
