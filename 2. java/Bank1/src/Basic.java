import interfaces.IConsultaSaldo;
import interfaces.IPagoServicios;
import interfaces.IRetiroEfectivo;

public class Basic implements IConsultaSaldo, IPagoServicios, IRetiroEfectivo {

    @Override
    public void consultarSaldo() {
        System.out.println("su saldo es:");
    }

    @Override
    public void transaccionOk(String tipoTransaccion) {
        System.out.println("transaccion ok");
    }

    @Override
    public void transaccionNoOk(String tipoTransaccion) {
        System.out.println("trransacion fallida");
    }

    @Override
    public void pagarServicio() {
        System.out.println("se esta pagando servicio");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("retirando dinero");
    }

}
