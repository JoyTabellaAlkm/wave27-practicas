package org.example.entidades;

import org.example.interfaces.ITransaccion;

public class Transferencia implements ITransaccion {
    @Override
    public void TransaccionOk() {
        System.out.println("Transferencia OK");
    }

    @Override
    public void TransaccionNoOk() {
        System.out.println("Transferencia NO OK");
    }
}
