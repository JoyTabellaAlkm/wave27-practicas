package clientes;

import transacciones.ConsultaSaldo;
import transacciones.RetiroEfectivo;
import transacciones.Transacciones;

public class Cobradores {
    private Transacciones transacciones;

    public void retiroDeEfectivo(){
        this.transacciones = new RetiroEfectivo();
        this.transacciones.transaccionOk();
    }

    public void consultaDeSaldos(){
        this.transacciones = new ConsultaSaldo();
        this.transacciones.transaccionOk();
    }
}
