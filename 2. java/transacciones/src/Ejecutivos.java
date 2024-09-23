public class Ejecutivos implements IDeposito, ITransferencia, ITransaccion{

    @Override
    public void hacerDeposito() {
        System.out.println("El ejecutivo hace un deposito");
    }

    @Override
    public void hacerTransferencia() {
        System.out.println("El ejecutivo hace una transferencia");
    }

    @Override
    public void transaccionOk() {

    }

    @Override
    public void transaccionNoOk() {

    }
}
