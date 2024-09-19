import interfaces.IConsultaSaldo;
import interfaces.IRetiroEfectivo;

public class Cobradores implements IRetiroEfectivo, IConsultaSaldo {
    @Override
    public void consultarSaldo() {
        System.out.println("consultando salto");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("se esta retirando dinero en efectivo");
    }

    @Override
    public void transaccionOk(String tipoTransaccion) {
        System.out.println("trasaccion exitosa");
    }

    @Override
    public void transaccionNoOk(String tipoTransaccion) {
        System.out.println("trasnacio fallida");
    }
}
