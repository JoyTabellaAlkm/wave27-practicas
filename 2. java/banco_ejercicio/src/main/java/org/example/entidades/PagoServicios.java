package org.example.entidades;

import org.example.interfaces.ITransaccion;

public class PagoServicios implements ITransaccion {
    @Override
    public void TransaccionOk() {
        System.out.println("Pago Servicios OK");
    }

    @Override
    public void TransaccionNoOk() {
        System.out.println("Pago Servicios NO OK");
    }
}
