package transacciones;

public class PagoServicios implements Transacciones{
    @Override
    public void transaccionOk() {
        System.out.println("Realizando pago de servicios");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al realizar pago de servicios");
    }
}
