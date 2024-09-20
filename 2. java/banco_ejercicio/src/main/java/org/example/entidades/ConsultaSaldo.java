package org.example.entidades;

import org.example.interfaces.ITransaccion;

public class ConsultaSaldo implements ITransaccion {
    @Override
    public void TransaccionOk() {
        System.out.println("Consulta Saldo OK");
    }

    @Override
    public void TransaccionNoOk() {
        System.out.println("Consulta Saldo NO OK");
    }
}
