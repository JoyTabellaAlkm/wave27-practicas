package ClasesAbstractasLandas.Ejercicio1.Transacciones;

public class Deposito implements Transaccion{
    @Override
    public void TransaccionOK() {
        System.out.println("El cliente puede realizar el deposito");
    }

    @Override
    public void TransaccioNoOK() {
        System.out.println("El cliente NO puede realizar el deposito");
    }
}
