package entity;

public class ConsultaSaldo implements ITransaccion {
    @Override
    public void transaccionOk() {
    System.out.println("Consultando saldo...");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo consultar el saldo");
    }
}