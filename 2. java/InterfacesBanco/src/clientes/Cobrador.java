package clientes;

import transacciones.IConsultaSaldo;
import transacciones.IRetiroEfectivo;

public class Cobrador implements IRetiroEfectivo, IConsultaSaldo {
    @Override
    public void transaccionOk() {
        System.out.println("Transaccion de cliente cobrador ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion de cliente cobrador fallida");
    }

    @Override
    public void consultaSaldo() {
        System.out.println("Consultado saldo como cliente cobrador");
    }

    @Override
    public void realizarRetiro() {
        System.out.println("Realizando retiro de efectivo por cliente cobrador");
    }
}
