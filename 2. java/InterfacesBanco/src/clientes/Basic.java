package clientes;

import transacciones.IConsultaSaldo;
import transacciones.IPagoServicios;
import transacciones.IRetiroEfectivo;

public class Basic implements IConsultaSaldo, IPagoServicios, IRetiroEfectivo {
    @Override
    public void transaccionOk() {
        System.out.println("Transacción de cliente basic exitosa");
    }
    @Override
    public void transaccionNoOk() {
        System.out.println("Transacción de cliente basic fallida");
    }

    @Override
    public void consultaSaldo() {
        System.out.println("Realizando consulta de saldo por cliente basic");
    }

    @Override
    public void realizarPago() {
        System.out.println("Relizando pago de servicios por cliente basic");
    }

    @Override
    public void realizarRetiro() {
        System.out.println("Realizando retiro de efectivo por cliente basic");
    }
}
