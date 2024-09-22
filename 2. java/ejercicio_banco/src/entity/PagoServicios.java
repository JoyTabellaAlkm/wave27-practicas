package entity;

public class PagoServicios implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Realizando pago de servicios...");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se ha podido realizar el pago de servicios");
    }
}
