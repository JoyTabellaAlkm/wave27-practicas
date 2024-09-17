package ClasesAbstractasLandas.Ejercicio1.Transacciones;

public class PagoServicios implements Transaccion {
    @Override
    public void TransaccionOK() {
        System.out.println("El cliente puede pagar los servicios");
    }

    @Override
    public void TransaccioNoOK() {
        System.out.println("El cliente NO puede pagar los servicios");
    }
}
