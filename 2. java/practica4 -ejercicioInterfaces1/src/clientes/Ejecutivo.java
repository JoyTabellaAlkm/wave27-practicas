package clientes;

import transacciones.Deposito;
import transacciones.Transacciones;
import transacciones.Trasferencia;

public class Ejecutivo {
    private Transacciones transacciones;

    public void transferencia(){
        this.transacciones = new Trasferencia();
        this.transacciones.transaccionOk();
    }

    public void deposito(){
        this.transacciones = new Deposito();
        this.transacciones.transaccionOk();
    }
}
