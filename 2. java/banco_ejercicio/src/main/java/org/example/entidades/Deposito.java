package org.example.entidades;

import org.example.interfaces.ITransaccion;

public class Deposito implements ITransaccion {
    @Override
    public void TransaccionOk() {
        System.out.println("Deposito OK");
    }

    @Override
    public void TransaccionNoOk() {
        System.out.println("Deposito NO OK");
    }
}
