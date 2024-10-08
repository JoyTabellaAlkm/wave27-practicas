package transacciones;

public class RetiroEfectivo implements Transacciones{
    @Override
    public void transaccionOk() {
        System.out.println("Retirando el efectivo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Saldo insuficiente");
    }
}
