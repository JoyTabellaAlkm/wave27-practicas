package org.bootcamp.clients;

import org.bootcamp.transactions.ConsultaDeSaldo;
import org.bootcamp.transactions.PagoDeServicios;
import org.bootcamp.transactions.RetiroDeEfectivo;
import org.bootcamp.transactions.Transaccion;

public class Basic implements ConsultaDeSaldo, PagoDeServicios, RetiroDeEfectivo, Transaccion {
    @Override
    public void consultar() {
        System.out.println("Básico consultando saldo...");
        ejecutarTransaccion("Consulta de saldo");
    }

    @Override
    public void pagar(String servicio) {
        System.out.printf("Básico pagando %s...%n", servicio);
        ejecutarTransaccion("Pago de %s".formatted(servicio));
    }

    @Override
    public void retirarEfectivo(double monto) {
        System.out.printf("Básico retirando $%s...%n", monto);
        ejecutarTransaccion("Retiro de $%s".formatted(monto));
    }

    @Override
    public void transaccionOk(String detalle) {
        System.out.println(detalle + " completado correctamente - Servicio básico");
    }

    @Override
    public void transaccionNoOk(String detalle) {
        System.out.println("Hubo un error ejecutando: " + detalle + " - Servicio básico");
    }
}
