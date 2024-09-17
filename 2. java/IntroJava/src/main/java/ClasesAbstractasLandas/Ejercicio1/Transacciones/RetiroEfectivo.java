package ClasesAbstractasLandas.Ejercicio1.Transacciones;

public class RetiroEfectivo implements Transaccion{
    @Override
    public void TransaccionOK() {
        System.out.println("El cliente puede retirar el efectivo");
    }

    @Override
    public void TransaccioNoOK() {
        System.out.println("El cliente NO puede retirar el efectivo");
    }
}
