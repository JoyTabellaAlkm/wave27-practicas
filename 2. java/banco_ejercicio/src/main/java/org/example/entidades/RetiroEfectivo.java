package org.example.entidades;

import org.example.interfaces.ITransaccion;

public class RetiroEfectivo implements ITransaccion {
    @Override
    public void TransaccionOk() {
        System.out.println("Retiro efectivo OK");
    }

    @Override
    public void TransaccionNoOk() {
        System.out.println("Retiro efectivo NO OK");
    }
}
