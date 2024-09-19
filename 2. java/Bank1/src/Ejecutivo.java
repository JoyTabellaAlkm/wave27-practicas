import interfaces.IDeposito;
import interfaces.ITransferencia;

public class Ejecutivo implements IDeposito, ITransferencia {


    @Override
    public void realizarDepositos() {
        System.out.println("realizo un deposito");
    }

    @Override
    public void realizarTransferencia() {
        System.out.println("realizo un transferencia");
    }


    @Override
    public void transaccionOk(String tipoTransaccion) {
        System.out.println("la transaccion"+tipoTransaccion+"fue exitosa");

    }

    @Override
    public void transaccionNoOk(String tipoTransaccion) {
        System.out.println("transaccion "+tipoTransaccion+" produjo un error");
    }
}
