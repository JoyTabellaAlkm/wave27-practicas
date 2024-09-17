package ClasesAbstractasLandas.Ejercicio1.Transacciones;

public class ConsultaSaldo implements Transaccion{

    @Override
    public void TransaccionOK() {
        System.out.println("El cliente puede consultar el saldo");
    }

    @Override
    public void TransaccioNoOK() {
        System.out.println("El cliente NO puede consultar el saldo");
    }
}
