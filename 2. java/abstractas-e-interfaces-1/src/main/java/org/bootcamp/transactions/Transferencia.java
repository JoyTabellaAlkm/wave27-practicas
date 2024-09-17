package org.bootcamp.transactions;

public interface Transferencia extends Transaccion {
    void transferir(double monto, String destinatario);
}
