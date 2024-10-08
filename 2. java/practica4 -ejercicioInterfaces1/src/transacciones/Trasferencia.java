package transacciones;

public class Trasferencia implements Transacciones {
    @Override
    public void transaccionOk() {
        System.out.println("Realizando transaccion");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al realizar transaccion");
    }
}
