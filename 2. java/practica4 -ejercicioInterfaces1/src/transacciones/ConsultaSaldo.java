package transacciones;

public class ConsultaSaldo implements Transacciones {
    @Override
    public void transaccionOk() {
        System.out.println("Realizando consulta de saldo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta erronea");
    }
}
