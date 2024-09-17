package ClasesAbstractasLandas.Ejercicio1.Transacciones;

public class Transferencia implements Transaccion{
    @Override
    public void TransaccionOK() {
        System.out.println("El cliente puede realizar la transferencia");
    }

    @Override
    public void TransaccioNoOK() {
        System.out.println("El cliente NO puede realizar la transferencia");
    }
}
