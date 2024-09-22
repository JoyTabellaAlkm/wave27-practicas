package entity;

public class RetiroEfectivo implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Retirando efectivo...");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se ha podido retirar efectivo");
    }
}