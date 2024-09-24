package Clientes;


import Transacciones.ITransaccionConsultaSaldo;
import Transacciones.ITransaccionPagoServicios;
import Transacciones.ITransaccionRetiroEfectivo;

public class Basic implements ITransaccionConsultaSaldo, ITransaccionPagoServicios, ITransaccionRetiroEfectivo {


    @Override
    public void transaccionOK() {
        System.out.println("Transacción OK");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("Transacción NO OK");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo");
    }

    @Override
    public void pagarServicios() {
        System.out.println("Pagando servicios");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Retirando efectivo");
    }
}
