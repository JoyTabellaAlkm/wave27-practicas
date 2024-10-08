package transacciones;

public class Deposito implements Transacciones {
    @Override
    public void transaccionOk() {
        System.out.println("Realizándose depósito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al realizar deposito");
    }
}
