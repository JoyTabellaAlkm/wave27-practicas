package clientes;

import transacciones.ConsultaSaldo;
import transacciones.PagoServicios;
import transacciones.RetiroEfectivo;
import transacciones.Transacciones;

public class Basic {
    private Transacciones transacciones;

    public void consultaDeSaldo(){
        this.transacciones = new ConsultaSaldo();
        this.transacciones.transaccionOk();
    }

    public void pagoDeServcios(){
        this.transacciones = new PagoServicios();
        this.transacciones.transaccionOk();
    }

    public void retiroDeEfectivo(){
        this.transacciones = new RetiroEfectivo();
        this.transacciones.transaccionOk();
    }
}
