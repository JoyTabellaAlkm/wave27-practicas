package org.bootcamp.transactions;

import java.util.Random;

public interface Transaccion {
    void transaccionOk(String detalle);
    void transaccionNoOk(String detalle);

    default void ejecutarTransaccion(String transaccion) {
        if (sistemaFuncionando()) {
            transaccionOk(transaccion);
        } else {
            transaccionNoOk(transaccion);
        }
    }

    private boolean sistemaFuncionando() {
        double rand = new Random().nextDouble(0, 1);
        return rand < 0.7;
    }
}
